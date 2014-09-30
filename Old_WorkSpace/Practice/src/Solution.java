import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

/* Head ends here */
    static void next_move(int posx, int posy, String[] board){
    	int X = 0, Y = 0;
    	int[] dX = new int[25];
    	int[] dY = new int[25];
    	int count = 0;
    	for(int i=0; i< board.length; i++)
    		for(int j=0; j< board.length; j++)
    		{
    			if(board[i].charAt(j) == 'd')
    			{
    				dX[count] = i;
    				dY[count] = j;
    				count++;
    			}
    		}
    	//add logic here
    }

/* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}
