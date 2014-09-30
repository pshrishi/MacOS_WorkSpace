import java.util.*;
public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.next();
		//System.out.println(s);
		char[] arr = s.toCharArray();
		//System.out.println(arr);
		Arrays.sort(arr);
		//System.out.println(arr);
		int flag = 0;
		for(int i=1; i<arr.length-1; i++)
		{
			if(arr[i-1]!= arr[i] && arr[i]!=arr[i+1])
				{
					flag=1;
					System.out.print(arr[i]);
					break;
				}
		}
		
	}

}
