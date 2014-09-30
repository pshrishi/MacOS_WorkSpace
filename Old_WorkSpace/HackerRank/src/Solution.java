/* Head ends here */
import java.util.*;
public class Solution {
       
          static void insertionSort(int[] ar) {
              int num = ar[ar.length - 1];
        	  for(int i = ar.length - 2; i>=0; i-- )
              {
            	  if(ar[i] > num)
            	  {
            		ar[i+1] = ar[i];
            		for(int j = 0; j<ar.length; j++)
              		  System.out.print(ar[j] + " ");
              	  	System.out.println();
            		if(i == 0)
        			{
        				ar[i] = num;
        				for(int j = 0; j<ar.length; j++)
                    		  System.out.print(ar[j] + " ");
              		  	System.out.println();
              		  	break;
        			}
            	  }
            	  else
            		  {
            		  	ar[i+1] = num;
            		  	for(int j = 0; j<ar.length; j++)
                  		  System.out.print(ar[j] + " ");
            		  	System.out.println();
            		  	break;
            		  }
            	  
              }
       }   

/* Tail starts here */
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           insertionSort(ar);
       }    
   }
