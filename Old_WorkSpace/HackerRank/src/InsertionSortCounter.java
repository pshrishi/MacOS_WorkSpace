import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSortCounter {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i<n; i++)
        {
            int num = in.nextInt();
            int counter = 0;
            int[] arr = new int[num];
            for(int j=0; j<num; j++)
            {
            	arr[j] = in.nextInt();
            	int temp = arr[j];
                int ind = j;
                while(ind>0 && arr[ind-1]>temp)
                {
                    arr[ind] = arr[ind-1];
                    --ind;
                    counter++;
                }
                arr[ind] = temp;
            }
            System.out.println(counter);
        }
    }//MAIN
    /*
    public static void insertionSort(int[] arr)
    {
        int counter = 0;
        for(int i=1; i<arr.length; i++)
        {
            int temp = arr[i];
            int in = i;
            while(in>0 && arr[in-1]>temp)
            {
                arr[in] = arr[in-1];
                --in;
                counter++;
            }
            
            arr[in] = temp;
        }
        System.out.println(counter);
        
    }*/
}