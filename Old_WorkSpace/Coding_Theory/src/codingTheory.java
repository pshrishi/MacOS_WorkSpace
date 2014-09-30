import java.util.Arrays;
import java.util.Scanner;
public class codingTheory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 'k' : ");
		int k = in.nextInt();
		System.out.println("Enter 'n' : ");
		int n = in.nextInt();
		
		int[][] gen_matrix = new int[k][n];
		
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.println(i+":"+j+"-");
				gen_matrix[i][j] = in.nextInt();
			}
		}
		
		System.out.println("Generator Matrix - ");	
		
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(gen_matrix[i][j]);
			}
			System.out.println();
		}
		
		int[][] mult_matrix = new int[(int) Math.pow(2, k)][k];
		
		for(int i=0;i<Math.pow(2, k);i++)
		{
			for(int j=0;j<k;j++)
			{
				mult_matrix[i][j] = 0;
			}
		}
		
		for(int i=0;i<Math.pow(2, k);i++)
		{
			int m = i;
			int j = k-1;
			while(m>0)
			{
				mult_matrix[i][j] = m%2;
				m /= 2;
				j--;
			}
 		}
		
		/*System.out.println("Multiplier Matrix - ");
		
		for(int i=0;i<Math.pow(2, k);i++)
		{
			for(int j=0;j<k;j++)
			{
				System.out.print(mult_matrix[i][j]);
			}
			System.out.println();
		}*/
		
		int[][] result = new int[(int) Math.pow(2, k)][n];
		for(int i = 0; i < Math.pow(2, k); i++) {
			  for(int j = 0; j < n; j++) {
				  result[i][j] = 0;
			  for(int g = 0; g < k; g++){
			  
			  result[i][j] += mult_matrix[i][g]*gen_matrix[g][j];
			  }
			  result[i][j] %= 2;
			  }  
			 }
		
		System.out.println("\nCodewords - ");
		
		for(int i=0;i<Math.pow(2, k);i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(result[i][j]);
			}
			System.out.print("\t");
		}
		
		System.out.println("\n\nWeights - ");
		int[] wts = new int[(int) Math.pow(2, k)];
		for(int i=0; i<Math.pow(2, k);i++)
		{
			wts[i]=0;
			for(int j=0;j<n;j++)
			{
				wts[i] += result[i][j];
			}
		}
		for(int i=0; i<Math.pow(2, k);i++)
		{
			System.out.print(wts[i]+"\t");
		}
		
		System.out.println("\n\nWeight Count - ");
		
		int[] wt_count = new int[(int) Math.pow(2, k)];
		
		for(int i=0; i<Math.pow(2, k);i++)
		{
			wt_count[i]=0; 
			}
		
		for(int i=0; i<Math.pow(2, k);i++)
		{
			wt_count[wts[i]]++; 
		}
		for(int i=0; i<Math.pow(2, k);i++)
		{
			System.out.println(i+":"+wt_count[i]); 
		}
		
		System.out.println("\nWeight Enumerator Polynomial - ");
		for(int i=0; i<Math.pow(2, k);i++)
		{
			System.out.print(wt_count[i]+"z"+i+"\t"); 
		}
		
		Arrays.sort(wts);
		System.out.println("\n\nMin. distance - " + wts[1]);
	}
		
}