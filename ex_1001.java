//1001. Обратный корень(Accepted)

import java.util.Scanner;
import java.util.ArrayList;

public class ex_1001 {
	public static void main( String[] args ) {
		ArrayList<Long> values = new ArrayList<Long>();
		Scanner in = new Scanner( System.in );
		while ( in.hasNextLong() == true ) {
			values.add( in.nextLong());
		}
		for ( int i = values.size() - 1; i >= 0; i-- ) {
			System.out.println( String.format( "%.4f", Math.sqrt( values.get( i ))));
		}
	}
}