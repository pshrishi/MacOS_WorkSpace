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
using Leap;

namespace BTP
{
    /// <summary>
    /// Interaction logic for LeapScreen.xaml
    /// </summary>
    public partial class LeapScreen : Window
    {
        public LeapScreen()
        {
            InitializeComponent();
        }

        private void ch1_MouseDown_1(object sender, MouseButtonEventArgs e)
        {
            TutScreen main = new TutScreen(1, 1);
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }

        private void ch2_MouseDown_1(object sender, MouseButtonEventArgs e)
        {
            TutScreen main = new TutScreen(2, 1);
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }

        private void ch3_MouseDown_1(object sender, MouseButtonEventArgs e)
        {
            TutScreen main = new TutScreen(3, 1);
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }
        private void ch4_MouseDown_1(object sender, MouseButtonEventArgs e)
        {
            TutScreen main = new TutScreen(4, 1);
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }

        private void ch5_MouseDown_1(object sender, MouseButtonEventArgs e)
        {
            TutScreen main = new TutScreen(5, 1);
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }

        private void ch6_MouseDown_1(object sender, MouseButtonEventArgs e)
        {
            TutScreen main = new TutScreen(6, 1);
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }

        private void ch7_MouseDown_1(object sender, MouseButtonEventArgs e)
        {
            TutScreen main = new TutScreen(7, 1);
            App.Current.MainWindow = main;
            this.Close();
            main.Show();
        }

        
    }
}
