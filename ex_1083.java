/*
1083. Факториалы!!!(Accepted)
*/

import java.util.Scanner;

public class ex_1083 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		String text = in.nextLine();
		String[] value = text.split( " " );
		int n = Integer.parseInt( value[0] ), k = value[1].length();
		int res = 1, end = 0;
		System.out.println( getFactorial( n, k ));
	}
	
	public static int getFactorial( int n, int k ) {
		int result = 1;
		while ( n > 0 ) {
			result *= n;
			n -= k;
		}
		return result;
	}
}