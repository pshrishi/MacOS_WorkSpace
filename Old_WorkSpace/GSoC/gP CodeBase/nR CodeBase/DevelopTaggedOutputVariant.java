import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class DevelopTaggedOutputVariant
{
	public static void main(String args[])
	{
		File inputDir = new File(args[0]);
		File outputDir = new File(args[1]);
		File helpDir = new File(args[2]);
		//String[] inputFiles = inputDir.list();
		String ipFileName = "", hpFileName = "", line = "", lineH= "", opFileName = "", tempStr = "", iltimexType = "", sOutput;
		String [] entryList, helpList;
		BufferedReader br = null, brH = null;
		BufferedWriter bw = null, bwAll = null;
		int i = 0, flagTimexOn = 0, tempFlagTimexOn = 0, k = 0;
		int fileNameStart = Integer.parseInt(args[3]);
		int maxFiles = Integer.parseInt(args[4]);	
		
		try
		{
			bwAll = new BufferedWriter(new FileWriter(outputDir + "/C-All.xml"));
			bwAll.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); bwAll.newLine();
			bwAll.write("<DOC><TEXT>"); bwAll.newLine();
		}
        	catch (Exception ex) 
        	{
        		System.out.println("Exception Encountered: " + ex.toString());
        		return;
		}

		for(i = fileNameStart; i < (fileNameStart+maxFiles);i++)
		{
			flagTimexOn = 0; tempFlagTimexOn = 0;
			ipFileName = inputDir + "/C-" + i + ".txt";
			opFileName = outputDir + "/C-" + i + ".txt";
			hpFileName = helpDir + "/C-" + i + ".txt";
			sOutput = new String();
			try
	        	{
				br = new BufferedReader(new FileReader(new File(ipFileName)));
				brH = new BufferedReader(new FileReader(new File(hpFileName)));
				bw = new BufferedWriter(new FileWriter(new File(opFileName)));
				while((line = br.readLine()) != null)
			    	{
					if(line.startsWith("#") == false)
					{						
						entryList = line.split("\t");
						lineH = brH.readLine();
						helpList = lineH.split("\t");
						System.out.println(line + " " + lineH);
						if(entryList[0].equals(""))
						{
							continue;
						}						
						else if (entryList[1].equals("."))
						{
							sOutput = sOutput + "।";
						}
						else
						{
							if(entryList[5].substring(0, entryList[5].indexOf("/")).equals("O"))
							{
								if(flagTimexOn > 0)
								{
									flagTimexOn = 0;
									sOutput = sOutput + "</ILTIMEX> " + helpList[0];
								}
								else
								{
									sOutput = sOutput + " " + helpList[0];
								}
							}
							else
							{
								tempFlagTimexOn = flagTimexOn;
								tempStr = entryList[5].substring(0, entryList[5].indexOf("/"));
								iltimexType = tempStr.substring(entryList[5].indexOf("-")+1);
								if(iltimexType.equals("P")) flagTimexOn = 1;
								else if(iltimexType.equals("D")) flagTimexOn = 2;
								else if(iltimexType.equals("F")) flagTimexOn = 3;

								if(flagTimexOn == tempFlagTimexOn)
								{
									sOutput = sOutput + " " + helpList[0];
								}
								else
								{
									sOutput = sOutput + " <ILTIMEX TYPE=\"" + iltimexType + "\">" + helpList[0];
								}
							}
						}
					}
			    	}
				bw.write("<DOC><TEXT>" + sOutput.trim() + "</TEXT></DOC>");
				bwAll.write(sOutput.trim());
				bwAll.newLine();
				br.close();
				brH.close();
				bw.close();
	        	}
	        	catch (Exception ex) 
	        	{
	        		System.out.println("Exception Encountered: " + ex.toString());
	        		return;
			}
			
		}

		try
		{
			bwAll.write("</TEXT></DOC>");
			bwAll.close();	
		}
        	catch (Exception ex) 
        	{
        		System.out.println("Exception Encountered: " + ex.toString());
        		return;
		}

	}
}
