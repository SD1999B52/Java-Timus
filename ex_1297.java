//1297. Палиндромы
//qwertypoETEopytrewq

import java.util.ArrayList;
import java.util.Scanner;

public class ex_1297 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		String text = in.nextLine();
		
		ArrayList<String> palindroms = new ArrayList<String>();
		int maxlength = 0;
		for ( int i = 0; i < text.length(); i++ ) {
			for ( int i2 = 0; i2 < text.length() - i; i2++ ) {
				String subtext = text.substring( i, text.length() - i2 );
				if ( palindrome( subtext ) == true ) {
					if ( maxlength < subtext.length()) {
						maxlength = subtext.length();
					}
					palindroms.add( subtext );
				}
			}
		}
		for ( int i = 0; i < palindroms.size(); i++ ) {
			if (  palindroms.get( i ).length() == maxlength ) {
				System.out.println( palindroms.get( i ));
				break;
			}
		}
	}
	
	public static boolean palindrome( String text ) {
		if ( text.length() == 1 ) {
			return false;
		}
		for ( int i = 0; i < Math.floor( text.length() / 2 ); i++ ) {
			if ( text.charAt( i ) != text.charAt( text.length() - 1 - i )) {
				return false;
			}
		}
		return true;
	}
}