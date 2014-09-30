import java.util.*;
public class Solution1 {
    
       public static void insertionSort(int[] ar){
    	   for(int i = 1; i<ar.length; i++)
    	   {
    		   for(int j = 0; j<i; j++)
    		   {
    			   
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