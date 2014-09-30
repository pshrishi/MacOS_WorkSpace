import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class FeatureVectorGenerator 
{
	private String pivot = "सोमवार|मंगलवार|बुधवार|बुद्धवार|बृहस्पतिवार|गुस्र्वार|गुरुवार|शुक्रवार|शनिवार|रविवार|जनवरी|फरवरी|मार्च|अप्रैल|मई|जून|जुलाई|अगस्त|सितंबर|सितम्बर|अक्टूबर|नवंबर|नवम्बर|दिसंबर|दिसम्बर|युगों|ज़मानो|जमानो|अर्सों|अरसो|सहस्राब्दीयों|शताब्दियों|सदियों|दशकों|वर्षो|वर्षों|सालों|बरसों|महीनो|महीने|हफ्ते|तड़के|दिनों|घंटों|युग|जमाना|ज़माना|अरसा|सहस्राब्दी|शताब्दी|सदी|दशक|वर्ष|साल|बरस|माह|मास|महीना|सप्ताह|हफ़्ता|तिथि|दिन|दिवस|काल|समय|अवधि|कल|परसों|रोज़|ग्रीष्मऋतु|शीतऋतु|वर्षाऋतु|गर्मियों|सर्दियों|सुबह|सवेरा|सवेरे|दोपहर|अपराह्न|शाम|विकाल|संध्या|रात|रात्रि|आधीरात|आधीरात्रि|मध्यरात्रि|अधरात्रि|पहर|घंटे|घंटो|मिनटों|क्षणों|घंटा|मिनट|क्षण|भूतकाल|भविष्यकाल|वर्तमानकाल|January|january|Jan|jan|February|february|Feb|feb|March|march|Mar|mar|April|april|Apr|apr|May|may|June|june|Jun|jun|July|july|Jul|jul|August|august|Aug|aug|September|september|Sep|sep|October|october|Oct|oct|November|november|Nov|nov|December|december|Dec|dec|आज|कल|परसों|साप्ताहिक|वार्षिक|सालाना|मासिक|माहवार|प्रतिमास|दैनिक|प्रतिदिन|रोज़ाना|रोज़|आजकल|अतीत|दिवाली|दीवाली|दीपावली|होली|दशहरा|दशहरे|स्वतंत्रता दिवस|गणतंत्र दिवस|ईद|क्रिसमस";
	
	private HashMap<String, String> serReadStemHM;

	/*FeatureVectorGenerator()
	{
		try
		{
			ObjectInputStream inputSer = new ObjectInputStream(new FileInputStream(new File("hiStemResource.ser")) ) ;
			serReadStemHM = (HashMap<String, String>) inputSer.readObject();
		}
		catch(Exception ex)
		{
			serReadStemHM = null;
		}
	}*/

	public String getFeatureVector(String hiToken, String POS)
	{
		String featureVector = new String();

		//Feature 1: Is Pivot Word-------------------------------------------------------------------------------------------------
		
		//Checking POS Tag matches any of NN(Primarily), NNP, DEM, QC, JJ, NST
		/*boolean rightPOS = false;

		if(POS.equals("NN") || POS.equals("NNP") || POS.equals("DEM") || POS.equals("QC") || POS.equals("JJ") || POS.equals("NST"))
			rightPOS = true;
		else
			rightPOS = false;*/

		Pattern p = Pattern.compile(pivot);
		Matcher m = p.matcher(hiToken);

		//if(m.matches() && rightPOS) featureVector = featureVector + "1\t"; else featureVector = featureVector + "0\t";

		if(m.matches()) featureVector = featureVector + "1\t"; else featureVector = featureVector + "0\t";

		//Feature 2: Suffix of the hindi token--------------------------------------------------------------------------------------
		//Adding the suffix (3 letter) of the Hindi Token to featureVector
		/*int length = hiToken.length();
		if(length > 3)
		{
			featureVector = featureVector + hiToken.substring(length-3) + "\t";
		}
		else
		{
			featureVector = featureVector + hiToken  + "\t";
		}*/

		//Feature 3: Stem of the hindi token----------------------------------------------------------------------------------------
		/*if(serReadStemHM.containsKey(hiToken))
		{
			featureVector = featureVector + serReadStemHM.get(hiToken) + "\t";
		}
		else
		{
			featureVector = featureVector + " \t";
		}*/


		//Feature 4: Is Hindi Token a Number with Punctuation Marks-----------------------------------------------------------------
		if (hiToken.matches("[१२३४५६७८९०0123456789]+([:-]+[१२३४५६७८९०0123456789]*)?")) featureVector = featureVector + "1";
		else featureVector = featureVector + "0";

		return featureVector;
	}
}
