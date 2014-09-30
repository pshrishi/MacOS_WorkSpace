using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Leap;


namespace StoreFinger
{


    class SampleListener : Listener
    {
        private Object thisLock = new Object();

        private Frame lastFrame;
        private int stateM;
        private int stateN;
        private int stateT;

        private void SafeWriteLine(String line)
        {
            lock (thisLock)
            {
                Console.WriteLine(line);
            }
        }

        public override void OnInit(Controller controller)
        {
            SafeWriteLine("Initialized");

            stateM = new int();
            stateN = new int();
            stateT = new int();

            stateN = 0;
            stateM = 0;
            stateT = 0;
        }

        public override void OnConnect(Controller controller)
        {
            SafeWriteLine("Connected");
        }

        public override void OnDisconnect(Controller controller)
        {
            SafeWriteLine("Disconnected");
        }

        public override void OnExit(Controller controller)
        {
            SafeWriteLine("Exited");
        }

        public override void OnFrame(Controller controller)
        {
            // Get the most recent frame and report some basic information
            Frame frame = controller.Frame();
            if (lookForK(frame))
            {
                SafeWriteLine("L");
            }

            //SafeWriteLine(frame.Hands[0].Direction.x.ToString());

            //float[] xy = getScreenProjection(frame.Hands[0].Pointables[0], controller);

            //SafeWriteLine("X: " + xy[0] + ", Y: " + xy[1] );
             
        }

        float[] getScreenProjection(Pointable pointable, Controller controller)
        {
            float[] xy = new float[2];

            Screen screen = controller.CalibratedScreens[0];//   .calibratedScreens().get(0);
            Vector point = pointable.TipPosition - screen.BottomLeftCorner;// hand.pointables().get(0).tipPosition().minus(screen.bottomLeftCorner());
            Vector xAxis = screen.HorizontalAxis;// screen.horizontalAxis();
            Vector yAxis = screen.VerticalAxis;//.verticalAxis();

            Vector xProj = xAxis * (xAxis.Dot(point) / xAxis.MagnitudeSquared);//  xAxis.times(xAxis.dot(point)/xAxis.magnitudeSquared()); 
            Vector yProj = yAxis * (yAxis.Dot(point) / yAxis.MagnitudeSquared);//yAxis.times(yAxis.dot(point)/yAxis.magnitudeSquared()); 


            float xLeap = xProj.Magnitude;
            float yLeap = yProj.Magnitude;

            float x = screen.WidthPixels * xLeap / xAxis.Magnitude;// screen.widthPixels() * xLeap/xAxis.magnitude();
            float y = screen.HeightPixels - screen.HeightPixels * yLeap / yAxis.Magnitude;// screen.heightPixels() - screen.heightPixels() * yLeap/yAxis.magnitude();
            SafeWriteLine("X: " + x + ", Y: " + y);

            xy[0] = x;
            xy[1] = y;

            return xy;
        }

        Boolean lookForA(Leap.Frame frame)
        {
            if (frame.Hands[0].Fingers.Count == 1)
            {
                //SafeWriteLine(frame.Hands[0].Fingers[0].Direction.AngleTo(frame.Hands[0].Direction).ToString());
                //SafeWriteLine(frame.Hands[0].Direction.ToString());
                //SafeWriteLine((frame.Hands[0].Fingers[0].Direction.x - frame.Hands[0].Direction.x).ToString());
                if ((frame.Hands[0].Fingers[0].Direction.x - frame.Hands[0].Direction.x) < (-0.10))
                {
                    return true;
                }
                return false;
            }
            else
            {
                return false;
            }
        }

        Boolean lookForB(Leap.Frame frame)
        {
            if (frame.Hands[0].Fingers.Count == 1)
            {
                //SafeWriteLine(frame.Hands[0].Fingers[0].Length.ToString()+"   "+frame.Hands[0].SphereRadius.ToString());
                if (frame.Hands[0].Fingers[0].Length < (frame.Hands[0].SphereRadius / 2 + 2))
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForC(Leap.Frame frame)
        {
            if (frame.Hands[0].Fingers.Count == 2)
            {
                Hand hand = frame.Hands[0];
                //SafeWriteLine(hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction).ToString()+"  "+hand.Fingers[0].Direction.AngleTo(hand.Direction).ToString()+"  "+hand.Fingers[1].Direction.AngleTo(hand.Direction).ToString());
                if ((hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction) > (0.20)) && (hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction) < (0.70)))
                {
                    if ((hand.Fingers[0].Direction.AngleTo(hand.Direction) > (0.5)) && (hand.Fingers[0].Direction.AngleTo(hand.Direction) < (0.90)))
                    {
                        if ((hand.Fingers[1].Direction.AngleTo(hand.Direction) > (0.3)) && (hand.Fingers[1].Direction.AngleTo(hand.Direction) < (0.7)))
                        {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        Boolean lookForD(Leap.Frame frame)
        {
            if (frame.Hands[0].Fingers.Count == 1)
            {
                SafeWriteLine(frame.Hands[0].Fingers[0].Length.ToString()+"  "+frame.Hands[0].SphereRadius.ToString());
                if ((frame.Hands[0].Fingers[0].Length < (frame.Hands[0].SphereRadius + 20)) && (frame.Hands[0].Fingers[0].Length > (frame.Hands[0].SphereRadius - 0)))
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForE(Leap.Frame frame)
        {
            if (frame.Hands.Count == 1)
            {
                if (frame.Hands[0].Fingers.Count == 0)
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForF(Leap.Frame frame)
        {
            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 3)
            {
                return true;
                FingerList fingers = hand.Fingers;
                if (!fingers.Empty)
                {
                    // Calculate the hand's average finger tip position
                    Vector avgPos = Vector.Zero;
                    Finger lastFinger;
                    lastFinger = hand.Fingers[0];
                    foreach (Finger finger in fingers)
                    {
                        if (lastFinger.TipPosition.x < finger.TipPosition.x)
                        {
                            lastFinger = finger;
                        }
                        avgPos += finger.Direction;
                    }
                    avgPos /= fingers.Count;
                    SafeWriteLine(avgPos.AngleTo(hand.Direction).ToString());
                    if ((avgPos.AngleTo(hand.Direction) > 0.010) && (avgPos.AngleTo(hand.Direction) < 0.4))
                    {
                       // SafeWriteLine(lastFinger.Direction.AngleTo(hand.Direction).ToString());
                        if ((lastFinger.Direction.AngleTo(hand.Direction) > 0.12) && (lastFinger.Direction.AngleTo(hand.Direction) < 0.3))
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        Boolean lookForG(Leap.Frame frame)
        {
            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 2)
            {
                //SafeWriteLine(hand.Fingers[0].Direction.x.ToString() + "  " + hand.Fingers[0].Direction.y.ToString() + "  " + hand.Fingers[0].Direction.z.ToString() + "  " + hand.Fingers[1].Direction.x.ToString() + "  " + hand.Fingers[1].Direction.y.ToString() + "  " + hand.Fingers[1].Direction.z.ToString());
                return true;
            }
            return false;
        }

        Boolean lookForH(Leap.Frame frame)
        {
            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 1)
            {
                //SafeWriteLine(hand.Fingers[0].Direction.x.ToString() + "  " + hand.Fingers[0].Direction.y.ToString() + "  " + hand.Fingers[0].Direction.z.ToString() + "  " + hand.Fingers[1].Direction.x.ToString() + "  " + hand.Fingers[1].Direction.y.ToString() + "  " + hand.Fingers[1].Direction.z.ToString());
                return true;
            }
            return false;
        }

        Boolean lookForI(Leap.Frame frame)
        {

            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 1)
            {
                //SafeWriteLine(hand.Fingers[0].Direction.x.ToString() + "  " + hand.Fingers[0].Direction.y.ToString() + "  " + hand.Fingers[0].Direction.z.ToString() + "  " + hand.Fingers[1].Direction.x.ToString() + "  " + hand.Fingers[1].Direction.y.ToString() + "  " + hand.Fingers[1].Direction.z.ToString());
                return true;
            }
            return false;
        }

        Boolean lookForJ(Leap.Frame frame)
        {
            return false; 
        }

        Boolean lookForK(Leap.Frame frame)
        {

            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 2)
            {
                SafeWriteLine(hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction).ToString());
                if ((hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction) < 0.35) && (hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction) > 0.1))
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForL(Leap.Frame frame)
        {

            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 2)
            {
                SafeWriteLine(hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction).ToString());
                if ((hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction) < 1.2) && (hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction) > 0.7))
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForM(Leap.Frame frame)
        {
            Hand hand = frame.Hands[0];
            if (stateM == 0)
            {
                SafeWriteLine("0");
                if (hand.Fingers.Count == 4 && frame.Hands.Count == 1)
                {
                    stateM = 1;
                    return false;
                }
                return false;
            }
            else if (stateM == 1)
            {
                SafeWriteLine("1 ");
                if (hand.Fingers.Count == 3 && frame.Hands.Count == 1)
                {
                    stateM = 2;
                    return false;
                }
                else if (hand.Fingers.Count == 2)
                {
                    stateM = 0;
                }
                else if (hand.Fingers.Count == 1 )
                {
                    stateM = 0;
                }
                return false;
            }
            else if (stateM == 2)
            {
                SafeWriteLine("2 ");
                if (hand.Fingers.Count == 0 && frame.Hands.Count == 1)
                {
                    //SafeWriteLine(hand.Fingers[0].Direction.AngleTo(hand.Direction).ToString());
                    return true;
                }
                else if (hand.Fingers.Count > 3)
                {
                    stateM = 0;
                }
                
                return false;
            }
            

            return false;
        }

        Boolean lookForN(Leap.Frame frame)
        {

            return false;
        }

        Boolean lookForO(Leap.Frame frame)
        {

            return false;
        }

        Boolean lookForP(Leap.Frame frame)
        {

            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 2)
            {
                //SafeWriteLine(hand.Fingers[0].Direction.x.ToString() + "  " + hand.Fingers[0].Direction.y.ToString() + "  " + hand.Fingers[0].Direction.z.ToString() + "  " + hand.Fingers[1].Direction.x.ToString() + "  " + hand.Fingers[1].Direction.y.ToString() + "  " + hand.Fingers[1].Direction.z.ToString());
                return true;
            }
            return false;
        }

        Boolean lookForQ(Leap.Frame frame)
        {

            return false;
        }

        Boolean lookForR(Leap.Frame frame)
        {

            return false;
        }

        Boolean lookForS(Leap.Frame frame)
        {
            if (frame.Hands.Count == 1)
            {
                if (frame.Hands[0].Fingers.Count == 0)
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForT(Leap.Frame frame)
        {

            return false;
        }

        Boolean lookForU(Leap.Frame frame)
        {
            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 1)
            {
                return true;
            }
            return false;
        }

        Boolean lookForV(Leap.Frame frame)
        {
            Hand hand = frame.Hands[0];
           if (hand.Fingers.Count == 2)
            {
                //SafeWriteLine(hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction).ToString());
                if (hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction) < 0.35)
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForW(Leap.Frame frame)
        {
            Hand hand = frame.Hands[0];
            if (hand.Fingers.Count == 3)
            {
                SafeWriteLine(hand.Fingers[2].Direction.AngleTo(hand.Fingers[1].Direction).ToString());
                if (hand.Fingers[0].Direction.AngleTo(hand.Fingers[1].Direction) < 0.35)
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForX(Leap.Frame frame)
        {
            Hand hand = frame.Hands[0];
            if(hand.Fingers.Count == 1)
            {
                //SafeWriteLine(hand.Fingers[0].Direction.AngleTo(hand.Direction).ToString());
                if (hand.Fingers[0].Direction.AngleTo(hand.Direction) > 0.7)
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForY(Leap.Frame frame)
        {
            if (frame.Hands[0].Fingers.Count == 2)
            {
                //SafeWriteLine(frame.Hands[0].Fingers[0].Direction.AngleTo(frame.Hands[0].Fingers[1].Direction).ToString());
                if ((frame.Hands[0].Fingers[0].Direction.AngleTo(frame.Hands[0].Fingers[1].Direction)) > 0.6)
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        Boolean lookForZ(Leap.Frame frame)
        {
            
            return false;
        }
    }


    class Program
    {
        static void Main(string[] args)
        {
            // Create a sample listener and controller
            SampleListener listener = new SampleListener();
            Controller controller = new Controller();

            // Have the sample listener receive events from the controller
            controller.AddListener(listener);

            // Keep this process running until Enter is pressed
            Console.WriteLine("Press Enter to quit...");
            Console.ReadLine();

            // Remove the sample listener when done
            controller.RemoveListener(listener);
            controller.Dispose();
        }

      
    }
}
