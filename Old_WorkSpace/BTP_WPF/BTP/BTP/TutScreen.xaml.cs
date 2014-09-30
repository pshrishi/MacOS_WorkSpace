using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Threading;
using System.Windows.Navigation;


namespace BTP
{
    /// <summary>
    /// Interaction logic for TutScreen.xaml
    /// </summary>
    public partial class TutScreen : Window
    {
        public int chapN;
        public int subChapN;
        public DispatcherTimer timer;
        public int counter;
        public int beepCounter;
       
        public TutScreen(int chapNumber, int subChapNumber)
        {
            
            InitializeComponent();
            HandArrow1.Visibility = Visibility.Visible;
            HandArrow2.Visibility = Visibility.Hidden;
            HandArrow3.Visibility = Visibility.Hidden; 
            chapN = chapNumber;
            subChapN = subChapNumber;
            
            counter = new int();
            counter = 0;

            beepCounter = new int();
            beepCounter = 0;

            timer = new DispatcherTimer();
            timer.Tick += timer_Tick;
            timer.Interval = new TimeSpan(0, 0, 2);

            timer.Start();
            
            string imagePath = "C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/data/" + /*chapN.ToString() + subChapN.ToString() +*/ "11.jpg";
            TutImage.Source = new BitmapImage(new Uri(imagePath));
           
   
        }

        void timer_Tick(object sender, EventArgs e)
        {
            //throw new NotImplementedException();

            if (counter == 0)
            {
                counter++;
                HandArrow1.Visibility = Visibility.Visible;
                HandArrow2.Visibility = Visibility.Hidden;
                HandArrow3.Visibility = Visibility.Hidden;
                dot1_down.Visibility = Visibility.Hidden;
                dot2_down.Visibility = Visibility.Hidden;
                dot3_down.Visibility = Visibility.Hidden;
                dot1_up.Visibility = Visibility.Hidden;
                dot2_up.Visibility = Visibility.Hidden;
                dot3_up.Visibility = Visibility.Hidden;
            }

            if (counter == 1)
            {
                HandArrow1.Visibility = Visibility.Hidden;
                HandArrow2.Visibility = Visibility.Visible;
                dot1_down.Visibility = Visibility.Hidden;
                dot2_down.Visibility = Visibility.Hidden;
                dot3_down.Visibility = Visibility.Hidden;
                dot1_up.Visibility = Visibility.Hidden;
                dot2_up.Visibility = Visibility.Hidden;
                dot3_up.Visibility = Visibility.Hidden;
                string videoPath = "C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/data/" + chapN.ToString() + "1.wmv";
                TutVideo.Source = new Uri(videoPath, UriKind.Relative);
                TutVideo.MediaEnded += TutVideo_MediaEnded;
                counter++;
            }

            if (counter == 3)
            {
                //if(correct input)
                //dot1_up.Visibility = Visibility.Visible;
                if(beepCounter == 0)
                {
                    beep1.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
                }
                else if (beepCounter == 1)
                {
                    beep2.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
                }
                else if (beepCounter == 2)
                {
                    beep3.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
                }
                else if (beepCounter == 3)
                {
                    beep4.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
                }
                else if (beepCounter == 4)
                {
                    beep5.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
                }
                else if (beepCounter == 5)
                {
                    beep6.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
                }
                else if (beepCounter == 6)
                {
                    beep7 .Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
                }
                else if (beepCounter == 7)
                {
                    beep8.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
                }
                else if (beepCounter == 8)
                {
                    int subChapNew = subChapN + 1;
                    if (subChapNew == 2)
                    {
                        QuizScreen q = new QuizScreen(chapN);
                        App.Current.MainWindow = q;
                        this.Close();
                        q.Show();
                    }
                    else
                    {
                        TutScreen t = new TutScreen(chapN, subChapNew);
                        App.Current.MainWindow = t;
                        this.Close();
                        t.Show();
                    }
                }
                beepCounter++;
            }
            
        }

        void TutVideo_MediaEnded(object sender, RoutedEventArgs e)
        {
            //throw new NotImplementedException();
            counter = 3;
            timer.Interval = new TimeSpan(0, 0, 1);
            HandArrow2.Visibility = Visibility.Hidden;
            HandArrow3.Visibility = Visibility.Visible;
        }

    }
}
