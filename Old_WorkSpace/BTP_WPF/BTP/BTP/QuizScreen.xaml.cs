using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Timers;
using System.Windows.Threading;

namespace BTP
{
    /// <summary>
    /// Interaction logic for QuizScreen.xaml
    /// </summary>
    public partial class QuizScreen : Window
    {
        public int chapN;
        public DispatcherTimer timer;
        public int counter;
        public int beepCounter;

        public QuizScreen(int x)
        {
            InitializeComponent();
            dot2_down.Visibility = Visibility.Hidden;
            dot2_up.Visibility = Visibility.Hidden;
            chapN = x;
            counter = new int();
            counter = 0;

            beepCounter = new int();
            beepCounter = 0;

            timer = new DispatcherTimer();
            timer.Tick += timer_Tick;
            timer.Interval = new TimeSpan(0, 0, 1);

            timer.Start();
            
            Random r = new Random();
            int nxt = r.Next(1, 5);
            display(x, nxt);
         }

        public void display(int chp, int indx)
        {
            switch (chp)
            {
                case 1:
                    switch (indx)
                    {
                        case 1:
                            textDisplay.Text = "A";
                            break;
                        case 2:
                            textDisplay.Text = "B";
                            break;
                        case 3:
                            textDisplay.Text = "C";
                            break;
                        case 4:
                            textDisplay.Text = "D";
                            break;
                        //other similar cases
                    }
                    break;
                //other similar cases
            }
        }

        void timer_Tick(object sender, EventArgs e)
        {
            //if(correct input)
            //dot2_up.Visibility = Visibility.Visible;
            if (beepCounter == 0)
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
                beep7.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
            }
            else if (beepCounter == 7)
            {
                beep8.Source = new BitmapImage(new Uri("C:/Users/Admin/Desktop/BTP_WPF/BTP/BTP/images/test1.png"));
            }
            else if (beepCounter == 8)
            {
                /*if (correct input)
                {
                    TutScreen t = new TutScreen(chapN + 1, 1);
                    App.Current.MainWindow = t;
                    this.Close();
                    t.Show();
                }
                else
                {
                    QuizScreen q = new QuizScreen(chapN);
                    App.Current.MainWindow = q;
                    this.Close();
                    q.Show();
                }*/
            }
            beepCounter++;
        }
    }
}
