import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;
public class RI_1 {

	/**
	 * @param args
	 */
	public static ArrayList<ArrayList<List<String>>> sel;
	public static int len;
	public static long product;
	public static long count = 1;
	//public static int int_product;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter sequence = ");
		String sequence = in.next();
		len = sequence.length();
		BigInteger[] seq = new BigInteger[len];
		BigInteger temp = new BigInteger(sequence);
		BigInteger max = new BigInteger("0");
		for(int i=0; i<len; i++)
		{
			seq[len - i -1] = temp.mod(BigInteger.valueOf(10));
			if(seq[len - i -1].compareTo(max) == 1)
				max = seq[len - i -1];
			temp = temp.divide(BigInteger.valueOf(10));
		}
		
		/*for(int i=0; i<len; i++)
		{
			System.out.println(seq[i]);
		}*/
		
		System.out.println("Enter theta - ");
		int theta = in.nextInt();
		while(len % theta != 0)
		{
			System.out.println("Re-enter theta - ");
			theta = in.nextInt();
		}		
		int rho = len/theta;
		System.out.println("Rho - " + rho);
		BigInteger[][] block = new BigInteger[theta][rho];
		for(int i=0; i<len; i++)
		{
			int col = i/theta;
			int row = i%theta;
			block[row][col] = seq[i];
		}
		/*for(int i=0; i<theta; i++)
			{
				for(int j=0; j<rho; j++)
				{
					System.out.print(block[i][j]);
				}
				System.out.println("");
			}
		*/
		String[][] tmp = new String[theta][rho];
		for(int i=0; i<theta; i++)
			for(int j=0; j<rho; j++)
			{
				tmp[i][j] = block[i][j].toString();
			}
		int[] cnt = new int[theta];
		sel = new ArrayList<ArrayList<List<String>>>();
		int SUM = 0;
		for(int i=0; i<theta; i++)
		{
			cnt[i] = 0;
			//Create the initial vector of 3 elements (apple, orange, cherry)
		   ICombinatoricsVector<String> originalVector = Factory.createVector(tmp[i]);

		   // Create the permutation generator by calling the appropriate method in the Factory class
		   Generator<String> gen = Factory.createPermutationGenerator(originalVector);

		   // Print the result
		   ArrayList<List<String>> gir = new ArrayList<List<String>>();
		   for (ICombinatoricsVector<String> perm : gen)
		      {
			   SUM++;
			   //System.out.print(i + " - " + perm.getVector());
			   gir.add(perm.getVector());
			   cnt[i]++;
			   //System.out.println("-----" + cnt[i]);
		      }
		   
		   sel.add(gir);
		}
		product = 1;
		for(int i=0; i<theta; i++)
		{
			product = product*cnt[i];
		}
		System.out.println("Total no. of equivalent sequences - " + product);
		
		/*for(int i=0; i<theta; i++)
			{
			for(int j=0; j<cnt[i]; j++)
				System.out.print(sel.get(i).get(j).toString());
			System.out.println("");	
			}
		*/
		
		Integer[] op = new Integer[len];
		for(int i=0; i<len; i++)
		{
			op[i] = 0;
		}
		for(int i=0; i<sel.get(0).size(); i++)
		{
			func(0, theta, rho, op);
		}
	}//MAIN
	static BigInteger unit = new BigInteger("1");
	static void func(int level, int theta, int rho, Integer[] arr)
	{
		if(level < theta-1)
		{
			for(int i=0; i<sel.get(level).size(); i++)
				{
				for(int j=0; j<rho; j++)
					{
						/*
						System.out.println("Value - " + sel.get(level).get(i).get(j));
						*/
						//System.out.println(level + "===" + i + "==="+ j);
						
						arr[level + j*theta] = Integer.parseInt(sel.get(level).get(i).get(j));
						/*for(int k=0; k<len; k++)
							System.out.print(arr[k].toString());
						System.out.println("");*/
					}
				func(level + 1, theta, rho, arr);
				}
			
		}
		else
		{	
			
			for(int i=0; i<sel.get(level).size(); i++)
				{
				for(int j=0; j<rho; j++)
					{
						
						arr[level + j*theta] = Integer.parseInt(sel.get(level).get(i).get(j));
						
					}
					if(count< product+1)
					{
					System.out.print("Sequence " +count +":");
					for(int k=0; k<len; k++)
						System.out.print(arr[k].toString());
					System.out.println("");
					count++;
					}
				}
			
			return;
		}
	}
}//CLASS
