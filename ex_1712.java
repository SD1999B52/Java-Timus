/*
1712. Шифровальная решётка(Accepted)
*/

import java.util.Scanner;

public class ex_1712 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		String[][] lattice = new String[4][4];
		String[][] key = new String[4][4];
		for ( int i = 0; i < 4; i++ ) {
			lattice[i] = in.nextLine().split( "" );
		}
		for ( int i = 0; i < 4; i++ ) {
			key[i] = in.nextLine().split( "" );
		}
		
		/*
		String[][] lattice = {
			{ ".", ".", ".", "." },
			{ "X", ".", ".", "X" },
			{ ".", "X", ".", "." },
			{ ".", ".", ".", "X" }
		};
		
		String[][] key = {
			{ "P", "w", "o", "o" },
			{ "K", "h", "a", "a" },
			{ "s", "m", "r", "s" },
			{ "o", "d", "b", "k" }
		};
		*/
		String text = "";
		for ( int ri = 0; ri < key.length; ri++ ) {
			for ( int i = 0; i < key.length; i++ ) {
				for ( int i2 = 0; i2 < key[0].length; i2++ ) {
					if ( lattice[i][i2].equals( "X" ) == true ) {
						text += key[i][i2];
					}
				}
			}
			lattice = rotateArray( lattice );
		}
		System.out.println( text );
	}
	
	public static String[][] rotateArray( String[][] array ) {
		String[][] newarray = new String[array.length][array[0].length];
		for ( int i = 0; i < array.length; i++ ) {
			for ( int i2 = 0; i2 < array[0].length; i2++ ) {
				newarray[i2][array[0].length - 1 - i] = array[i][i2];
			}
		}
		return newarray;
	}
}