import java.util.List;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;
public class RI_3_2{
	public static int nodes;
	public static int packets;
	public static int maxNode;
	public static int rFac;
	public static ArrayList<Set<Integer>> arr,arr2,arr3;
	public static ArrayList<int[]> bin_arr;
	public static Set<Integer> P;
	public static int[] kfr;
	public static int kfrCnt, flag3;
	public static Set<Integer> univ;
	public static ArrayList<ArrayList<List<String>>> sel;
    public static void main(String[] args)throws java.lang.Exception
    {
    	Scanner in = new Scanner(System.in);
    	PrintStream out = System.out;
    	
    	out.println("Enter the no. of nodes - ");
    	nodes = in.nextInt();
    	out.println("Enter the no. of packets - ");
    	packets = in.nextInt();
    	out.println("Enter the max. no. of packets at each node - ");
    	maxNode = in.nextInt();
    	out.println("Enter the replication factor - ");
    	rFac = in.nextInt();
    	univ = new HashSet<Integer>();
    	arr = new ArrayList<Set<Integer>>(nodes);
    	int temp = 0, sum = 0;
    	for(int i=0; i<nodes; i++)
    	{
    		out.println("Enter the no. of packets in node " + (i+1) + " : ");
    		temp = in.nextInt();
    		while(temp>maxNode || temp+sum>packets*rFac)
    		{
    			out.println("Incorrect data. Please re-enter the value : ");
    			temp = in.nextInt();
    		}
    		out.println("Now, enter the packets in node " + (i+1) + " : ");
    		if(temp+sum <= packets*rFac)
    		{
    			sum += temp;
    			Set<Integer> t = new HashSet<Integer>(temp); 
    			for(int j=0; j<temp; j++)
    			{
    				int iptNm = in.nextInt();
    				t.add(iptNm);
    				univ.add(iptNm);
    			}
    			arr.add(t);    				
    		}
    	}//FOR1
    	out.println("Node Packet Distribution : ");	
    	for(int i=0; i<nodes; i++)
    	{
    		out.println("Node - " + (i+1) + " : " + arr.get(i).toString());
    	}
    	out.println("Universal set : " + univ.toString());
    	//ALGO3
    	bin_arr = new ArrayList<int[]>();
    	
    	for(int i = 0;i<arr.size();i++)
    	{
    		int[] t_arr = new int[packets];
    		//Arrays.fill(t_arr, 0);
    		ArrayList<Integer> l = new ArrayList<Integer>(arr.get(i));
    		for(int j = 0;j<arr.get(i).size();j++)
    		{
    			t_arr[l.get(j) -1] = 1;
    			//out.print(""+l.get(j));
    		}
    		//out.println("temp array :"+t_arr.toString());
    		bin_arr.add(t_arr);
    		
    	}
    	out.println("Binary Array - ");
    	for(int i=0; i<bin_arr.size();i++)
    	{
    		for(int j = 0;j<packets; j++)
    		{
    			out.print(" " +bin_arr.get(i)[j]);
    		}
    		out.println("");
    	}
    	arr2 = new ArrayList<Set<Integer>>(packets);
    	for(int i=0; i<packets;i++)
    	{
    		Set<Integer> t_set = new HashSet<Integer>();
    		for(int j = 0;j<bin_arr.size(); j++)
    		{
    			if(bin_arr.get(j)[i]==1)
    				t_set.add(j+1);
    			
    		}
    		arr2.add(t_set);
    	}
    	out.println();
    	for(int i = 0;i<arr2.size();i++)
    	{
    		out.println("H" + (i+1) + ": " +arr2.get(i).toString());
    	}
    	Set<Integer> temp_set,temp_set2;
    	int[] rep_deg = new int[nodes];
    	for(int i = 0;i<nodes;i++)
    	{
    		flag3 = 0;
    		sel = new ArrayList<ArrayList<List<String>>>();

        	arr3 = new ArrayList<Set<Integer>>();
    		temp_set2 = new HashSet<Integer>();
    		temp_set2.add(i+1);
    		for(int j = 0;j<arr2.size();j++)
    		{
	    		if(arr2.get(j).contains(i+1))
	    		{
	    			temp_set = difference(arr2.get(j),temp_set2);
	    			if(temp_set.isEmpty())
	    			{
	    				flag3 = 1;
	    				rep_deg[i]= 0;
	    			}
	    			arr3.add(temp_set);
	    			//arr2.get(j).add(i+1);
	    		}
    		}
    		//String[] num_s = new String[arr3.size()];
    		/*for(int k = 0;k<arr3.size();k++)
        	{
    			//num_s[k] = Integer.toString(k+1);
        		out.println("H(arr3)" + (k+1) + ": " +arr3.get(k).toString());
        		
        	}*/

    		//ICombinatoricsVector<String> initialVector = Factory.createVector(num_s);
    		int flag2;
    		if(flag3 == 0)
    		{

  			   // Create a simple combination generator to generate 3-combinations of the initial vector
	    		FLAG : for(int l = arr3.size();l> 0;)
	    		{
	    			String[] num_s = new String[arr3.size()];
	    			for(int k = 0;k<arr3.size();k++)
	            	{
	        			num_s[k] = Integer.toString(k+1);
	            		//out.println("H(arr3)" + (k+1) + ": " +arr3.get(k).toString());
	            	}
	
	        		ICombinatoricsVector<String> initialVector = Factory.createVector(num_s);
	    			flag2 = 0;
	    			//out.println("array 3 size :" +arr3.size()+" l :" +l);
	    			Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, l);
	  			   	ArrayList<List<String>> gir = new ArrayList<List<String>>();
	  			   	for(ICombinatoricsVector<String> comb : gen)
	  			   	{
	  	  			 //Set<Integer> mySet = new HashSet<Integer>(Arrays.asList(comb.getVector())); 
	  				//  System.out.println("combinations for node" +i+ " - " + comb.getVector());
	  				   gir.add(comb.getVector());
	  			   	}
	  			   Set<Integer> temp_set3 = new HashSet<Integer>();
	  			   for( int p = 0;p<gir.size();p++)
	  			   {
	  				   temp_set3 = arr3.get(Integer.parseInt(gir.get(p).get(0)) - 1);
	  				   if(gir.get(p).size()>1)
	  				   {
		  				   for(int j = 1;j<gir.get(p).size();j++)
		  				   {
		  					   temp_set3 = intersection(arr3.get(Integer.parseInt(gir.get(p).get(j)) -1),temp_set3);
		  					   //out.println("intersection :" +arr3.get(Integer.parseInt(gir.get(p).get(j)) -1).toString());
	
		  				   }
		  				   //out.println("temp_set3 :" +temp_set3.toString());
		  				   if(temp_set3.isEmpty() == false)
		  				   {
		  					   int z = 0;
		  					   for(int j = 0;j<gir.get(p).size();j++)
		    				   {
		    					   //temp_set3 = intersection(arr3.get(),temp_set3);
		  						   //out.println("p: "+p+ " j:"+j+ "gir.get(p).get(j) :" +gir.get(p).get(j));
		  						   //out.println("set being deleted" +arr3.get(Integer.parseInt(gir.get(p).get(j)) -1 -z).toString());
		    					   arr3.remove(Integer.parseInt(gir.get(p).get(j)) -1 -z);
		    					   z++;
		    					   
		    				   }
		  					   rep_deg[i]++;
		  					   //System.out.println("IF : Repair degree of " + i + " - " + rep_deg[i]);
		  					   l = arr3.size();
		  					   break;
		  				   }
		  				   else
		  				   {
		  					   flag2 = 1;
		  				   }
	  				   }
	  				   else
	  				   {
	  					 arr3.remove(Integer.parseInt(gir.get(p).get(0)) - 1);
	  					 rep_deg[i]++;
						 //System.out.println("ELSE : Repair degree of " + i + " - " + rep_deg[i]);
	  					 l = arr3.size();
	  					 break;
	  				   }
	  			   }
	  			   if(flag2 == 1)
	  			   {
	  				   l--;
	  			   }
	    		}
    		}
    	}
    	for(int i = 0;i<rep_deg.length;i++)
    	{
    		out.println("Repair degree for node " +(i+1)+ ":" +rep_deg[i]);
    	}
    	//ALGO2 BEGINS
    	kfr = new int[nodes];
    	for(int i=0; i<nodes; i++)
    	{
    		//out.println("----------------------NEW NODE----------------------");
    		kfrCnt = 1;
    		P = arr.get(i);
    		//out.println("P : " + P.toString() + " i : " + i);
    		kfr[i] = 0;
    		Set<Integer> diff = difference(univ, P);
    		//out.println("Univ - P : " + diff);
    		if(diff.isEmpty() || diff.size() == 1)
    			step6(i, kfrCnt);
    		else
    			step3(P, i);
    	}//FOR
    	int mx = 0;
    	for(int i=0; i<nodes; i++)
    	{
    		if(kfr[i] > mx)
    			mx = kfr[i];
    		out.println("KFR(" + (i+1) + ") : " + kfr[i]);
    	}
    	out.println("----------------------***----------------------");
    	out.println("Max. KFR : " + mx);
    	out.println("----------------------***----------------------");
    	
    }//MAIN
    
    public static void step3(Set<Integer> P, int index){
    	PrintStream out = System.out;
		//out .println("----------------------STEP3----------------------");
    	//out.println("P : " + P.toString() + " i : " + index);
    	int flag = 0;
    	for(int i=0; i<nodes; i++)
		{
			Set<Integer> intrsctn = intersection(arr.get(i), P);
			//out.println("Arr("+i+") intr P : " + intrsctn.toString());
			if(intrsctn.isEmpty())
				{
					flag = 1;
				}
		}
    	if(flag == 1)
    		step4(P, index);
    	else
    		step5(P, index);
    }
    
    public static void step4(Set<Integer> P, int index){
    	PrintStream out = System.out;
    	//out.println("----------------------STEP4----------------------");
    	//out.println("P : " + P.toString() + " i : " + index);
    	Set<Integer> maxSet = null;
    	int max = 0;
		for(int i=0; i<nodes; i++)
		{
    		if(i == index)
    			continue;
    		Set<Integer> intrsctn = intersection(arr.get(i), P);
			//out.println("Arr("+i+") intr P : " + intrsctn.toString());
			if(intrsctn.isEmpty() && arr.get(i).size() > max)
			{
				maxSet = arr.get(i);
				max = arr.get(i).size();
				//out.println("Max : " + max);
			}
		}
		P = union(P, maxSet);
		//out.println("P : " + P.toString());
		kfrCnt++;
		Set<Integer> temp = difference(univ, P);
		//out.println("Univ - P : " + temp.toString());
		if(temp.isEmpty() || temp.size() == 1)
			step6(index, kfrCnt);
		else
			step3(P, index);
	}
    
    public static void step5(Set<Integer> P, int index){
    	PrintStream out = System.out;
    	//out.println("----------------------STEP5----------------------");
    	//out.println("P : " + P.toString() + " i : " + index);
    	Set<Integer> maxSet = null;
    	int max = 0;
		for(int i=0; i<nodes; i++)
		{
    		if(i == index)
    			continue;
    		Set<Integer> intrsctn = difference(arr.get(i), P);
			//out.println("Arr("+i+") - P : " + intrsctn.toString());
			Set<Integer> intrsctnR = difference(P, arr.get(i));
			//out.println("P - Arr("+i+") : " + intrsctnR.toString());
			if(intrsctnR.isEmpty() != true && intrsctn.size() > max)
			{
				maxSet = arr.get(i);
				max = intrsctn.size();
				out.println("Max : " + max);
			}
		}
		P = union(P, maxSet);
		out.println("P : " + P.toString());
		kfrCnt++;
		Set<Integer> temp = difference(univ, P);
		if(temp.isEmpty() || temp.size() == 1)
			step6(index, kfrCnt);
		else
			step5(P, index);
    }
    
    public static void step6(int index, int cnt){
    	PrintStream out = System.out;
    	//out.println("----------------------STEP6----------------------");
    	//out.println("Node : " + (index+1) + ", KFR : " + cnt);
    	kfr[index] = cnt;
    }
    
    public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new TreeSet<T>(setA);
        tmp.addAll(setB);
        return tmp;
      }

      public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new TreeSet<T>();
        for (T x : setA)
          if (setB.contains(x))
            tmp.add(x);
        return tmp;
      }

      public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new TreeSet<T>(setA);
        tmp.removeAll(setB);
        return tmp;
      }
      
}