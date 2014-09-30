import java.util.*;
public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] arr = s.split(" ");
		Stack<String> x = new Stack<String>();
		for(String str : arr)
		{
			x.push(str);
		}
		for(String str : arr)
		{
			System.out.print(x.pop() + " ");
		}
		
	}
}
