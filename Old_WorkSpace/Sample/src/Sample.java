import java.util.Scanner;
public class Sample {
	private static String last;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string - ");
		String str = in.nextLine();	
		System.out.println(str);	
		for(String retval : str.split(" "))
			System.out.println(retval);
		System.out.println("Enter string 1 - ");
		String x = in.next();
		System.out.println("Enter string 2 - ");
		String y = in.next();
		String z = lcs(x, y);
		System.out.println(z);
	}
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
	}
}