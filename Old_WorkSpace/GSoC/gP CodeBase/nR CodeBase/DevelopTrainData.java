import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DevelopTrainData 
{	
	public static void main(String args[])
	{
		File inputDir = new File(args[0]);
		File outputDir = new File(args[1]);
		String ipFileName = "", line = "", lineT = "", opFileName = "", trainData;
		String [] fourColEntryList;
		BufferedReader br = null, brT = null;
		BufferedWriter bw = null;
		FeatureVectorGenerator featureVectorGenerator = new FeatureVectorGenerator();		
	
		int i = 0;
		int fileNameStart = Integer.parseInt(args[2]);
		int maxFiles = Integer.parseInt(args[3]);
		
		for(i = fileNameStart; i < (fileNameStart+maxFiles);i++)
		{
			ipFileName = inputDir + "/C-" + i + ".txt";
			opFileName = outputDir + "/C-" + i + ".txt";

			try
	        	{
				br = new BufferedReader(new FileReader(new File(ipFileName)));
				bw = new BufferedWriter(new FileWriter(opFileName));
				while((line = br.readLine()) != null)
			    	{
					if(line.contains("Sentence") == false)
					{
						if(line.equals(""))
						{
							bw.newLine();
						}
						else
						{
							fourColEntryList = line.split("\t");
							trainData = featureVectorGenerator.getFeatureVector(fourColEntryList[0], fourColEntryList[3]);
							bw.write(fourColEntryList[1] + "\t" + fourColEntryList[3] + "\t" + trainData + "\t" + fourColEntryList[2]);
							bw.newLine();
						}
					}
			    	}
				br.close();
				bw.close();
	        	}
	        	catch (Exception ex) 
	        	{
	        		System.out.println("Exception Encountered: " + ex.toString());
	        		return;
			}
			
		}
	}

}
