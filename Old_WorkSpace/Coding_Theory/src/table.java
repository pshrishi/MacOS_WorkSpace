import java.util.Scanner;
public class table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter m - ");
		int m = in.nextInt();
		int[][] add = new int[(int) (Math.pow(2, m))][(int) (Math.pow(2, m))];
		int[][] mult = new int[(int) (Math.pow(2, m))][(int) (Math.pow(2, m))];
		for(int i=0;i<Math.pow(2, m);i++)
		{
			for(int j=0;j<Math.pow(2, m);j++)
			{
				add[i][j] = (int) ((i+j)%Math.pow(2, m));
				mult[i][j] = (int) ((i*j)%Math.pow(2, m));
			}
		}
		System.out.println("Addition - ");
		for(int i=0;i<Math.pow(2, m);i++)
		{
			for(int j=0;j<Math.pow(2, m);j++)
			{
				System.out.print(add[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("Multiplication - ");
		for(int i=0;i<Math.pow(2, m);i++)
		{
			for(int j=0;j<Math.pow(2, m);j++)
			{
				System.out.print(mult[i][j] + "\t");
			}
			System.out.println("");
		}
	}

}
