//1585. Пингвины(Accepted)

import java.util.Scanner;

public class ex_1585 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		int numLines = Integer.parseInt( in.nextLine());
		String[] array = new String[numLines];
		
		String[] types = {
			"Emperor Penguin",
			"Macaroni Penguin",
			"Little Penguin"
		};
		
		for ( int i = 0; i < numLines; i++ ) {
			array[i] = in.nextLine();
		}
		
		int[] num = new int[types.length];
		for ( int i = 0; i < types.length; i++ ) {
			for ( int i2 = 0; i2 < array.length; i2++ ) {
				if ( types[i].equals( array[i2] ) == true ) {
					num[i] += 1;
				}
			}
		}
		
		int idMax = 0;
		for ( int i = 0; i < num.length; i++ ) {
			if ( num[idMax] < num[i] ) {
				idMax = i;
			}
		}
		System.out.println( types[idMax] );
	}
}