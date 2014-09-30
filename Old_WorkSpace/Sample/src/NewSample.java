import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class NewSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstreami = new FileInputStream("Sample_Input.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstreami);
			  BufferedReader br1 = new BufferedReader(new InputStreamReader(in));
			  FileInputStream fstreamo = new FileInputStream("Sample_Locations.txt");
			  // Get the object of DataInputStream
			  DataInputStream op = new DataInputStream(fstreamo);
			  BufferedReader br2 = new BufferedReader(new InputStreamReader(op));
			  String strLine;
			  File file = new File("Output.txt");
			  file.createNewFile();
			  /*if (!exist)
			  {
			  System.out.println("File already exists.");
			  System.exit(0);
			  }*/
			  FileWriter fstreamot = new FileWriter("Output.txt");
			  BufferedWriter out = new BufferedWriter(fstreamot);
			  ArrayList<String> locations = new ArrayList<String>();
			  //Read File Line By Line
			  while ((strLine = br2.readLine()) != null) 
			  {
				  for(String retval : strLine.split(" "))
						locations.add(retval);
			  }
			  while ((strLine = br1.readLine()) != null) 
			  {
			  // Print the content on the console
				  for(String retval : strLine.split(" "))
						{
					  		int flag = 0;
					  		String tempStr = null;
					  		int bestIndex = 0;
					  		int bestSim = 0;
					  		for(int i=0; i<locations.size(); i++)
					  		{
					  			String r = retval.toLowerCase();
					  			String tS = locations.get(i).toLowerCase();
					  			String temp = lcs(r, tS);
					  			//System.out.println(r + "-" + tS + "-" + temp);
					  			if(tS.length() < 5)
					  			{
					  				if(temp.length() == tS.length())
					  				{
					  					flag = 1;
					  					bestIndex = i;
					  				}
					  			}
					  			else if(tS.length() - temp.length() < 2 )
					  			{
				  					flag = 1;
				  					tempStr = locations.get(i);
				  					bestIndex = i;
				  					bestSim = temp.length();
				  					if(temp.length() == tS.length())
				  					{
				  						bestIndex = i;
				  						break;
				  					}
				  					else if(bestSim <= temp.length())
				  						{
				  							bestSim = temp.length();
				  							bestIndex = i;
				  						}
					  			}
					  		}//FOR
					  		if(flag == 0)
					  			out.write(retval + " ");
					  		else
					  			out.write("<loc>" + locations.get(bestIndex).toLowerCase() + "</loc> ");
						}
				  out.write("\n");
			  }
			  //Close the input stream
			  in.close();
			  op.close();
			  out.close();
			  System.out.println("Program executed successfully. Please check the folder for output file named 'Output.txt'.");
			  }
		catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
	}//MAIN
	
	public static String lcs(String a, String b)
	{
	    int aLen = a.length();
	    int bLen = b.length();
	    if(aLen == 0 || bLen == 0)
	    {
	        return "";
	    }
	    else if(a.charAt(aLen-1) == b.charAt(bLen-1))
	    {
	        return lcs(a.substring(0,aLen-1),b.substring(0,bLen-1))
	            + a.charAt(aLen-1);
	    }
	    else
	    {
	        String x = lcs(a, b.substring(0,bLen-1));
	        String y = lcs(a.substring(0,aLen-1), b);
	        return (x.length() > y.length()) ? x : y;
	    }
	}//FUNC LCS
	
}//CLASS

