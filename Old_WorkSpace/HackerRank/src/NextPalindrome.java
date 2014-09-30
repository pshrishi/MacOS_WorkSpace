import java.util.*;
public class NextPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.next();
		
		int oriNum = Integer.valueOf(s);
		String temp = s.substring(0, (s.length()+1)/2);
		if(temp.length()%2 == 0)
		{
			StringBuffer ulta = new StringBuffer(temp);
			temp.concat((String) ulta);
		}
		
	}

}
