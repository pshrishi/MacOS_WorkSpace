import java.util.*;
public class OccurencesOfX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0; i<n; i++)
		{
			String s = in.next();
			int num = in.nextInt();
			int cnt = 0;
			for(int x=0; x<=s.length(); x++)
				for(int y=x+1; y<=s.length(); y++)
				{
					int counter = 0;
					String str = s.substring(x, y);
					for(int z=0; z<str.length(); z++)
						if(str.charAt(z) == 'X')
							counter++;
					if(counter == num)
						cnt++;
				}
			System.out.println(cnt);
		}
	}

}
