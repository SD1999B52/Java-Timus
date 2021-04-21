//1502. Точки домино(Accepted)

import java.util.Scanner;

public class ex_1502 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		int n = in.nextInt();
		long numDiamonds = 0;
		for ( int i = 0; i <= n; i++ ) {
			for ( int i2 = 0; i2 <= n; i2++ ) {
				if ( i2 >= i ) {
					numDiamonds += i + i2;
				}
			}
		}
		System.out.println( numDiamonds );
	}
}