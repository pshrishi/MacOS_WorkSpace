import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Main{
	public static int nodes;
	public static int packets;
	public static int maxNode;
	public static int rFac;
	public static ArrayList<Set<Integer>> arr;
	public static Set<Integer> P;
	public static int[] kfr;
	public static int kfrCnt;
	public static Set<Integer> univ;
	public static PrintStream out;
    public static void main(String[] args)throws java.lang.Exception
    {
    	Scanner in = new Scanner(System.in);
    	out = System.out;
    	
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
    	
    	//ALGO2 BEGINS
    	kfr = new int[nodes];
    	for(int i=0; i<nodes; i++)
    	{
    		out.println("----------------------NEW NODE----------------------");
    		kfrCnt = 1;
    		P = arr.get(i);
    		out.println("P : " + P.toString() + " i : " + i);
    		kfr[i] = 0;
    		Set<Integer> diff = difference(univ, P);
    		out.println("Univ - P : " + diff);
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
    	out.println("----------------------STEP3----------------------");
    	out.println("P : " + P.toString() + " i : " + index);
    	int flag = 0;
    	for(int i=0; i<nodes; i++)
		{
			Set<Integer> intrsctn = intersection(arr.get(i), P);
			out.println("Arr("+i+") intr P : " + intrsctn.toString());
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
    	out.println("----------------------STEP4----------------------");
    	out.println("P : " + P.toString() + " i : " + index);
    	Set<Integer> maxSet = null;
    	int max = 0;
		for(int i=0; i<nodes; i++)
		{
    		if(i == index)
    			continue;
    		Set<Integer> intrsctn = intersection(arr.get(i), P);
			out.println("Arr("+i+") intr P : " + intrsctn.toString());
			if(intrsctn.isEmpty() && arr.get(i).size() > max)
			{
				maxSet = arr.get(i);
				max = arr.get(i).size();
				out.println("Max : " + max);
			}
		}
		P = union(P, maxSet);
		out.println("P : " + P.toString());
		kfrCnt++;
		Set<Integer> temp = difference(univ, P);
		out.println("Univ - P : " + temp.toString());
		if(temp.isEmpty() || temp.size() == 1)
			step6(index, kfrCnt);
		else
			step3(P, index);
	}
    
    public static void step5(Set<Integer> P, int index){
    	out.println("----------------------STEP5----------------------");
    	out.println("P : " + P.toString() + " i : " + index);
    	Set<Integer> maxSet = null;
    	int max = 0;
		for(int i=0; i<nodes; i++)
		{
    		if(i == index)
    			continue;
    		Set<Integer> intrsctn = difference(arr.get(i), P);
			out.println("Arr("+i+") - P : " + intrsctn.toString());
			Set<Integer> intrsctnR = difference(P, arr.get(i));
			out.println("P - Arr("+i+") : " + intrsctnR.toString());
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
    	out.println("----------------------STEP6----------------------");
    	out.println("Node : " + (index+1) + ", KFR : " + cnt);
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