//1296. Гиперпереход(Accepted)

import java.util.Scanner;

public class ex_1296 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		int num = Integer.parseInt( in.nextLine());
		int[] lines = new int[num];
		
		for ( int i = 0; i < num; i++ ) {
			lines[i] = Integer.parseInt( in.nextLine());
		}
		
		System.out.println( maxGravPot( lines ));
	}
	
	public static int maxGravPot( int[] data ) {
		int sum = 0, answer = 0;
		for ( int i = 0; i < data.length; i++ ) {
			sum += data[i];
			if ( sum < 0 ) {
				sum = 0;
			}
			if ( sum > answer ) {
				answer = sum;
			}
		}
		return answer;
	}
}