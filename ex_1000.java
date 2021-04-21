/*
1000. A+B Problem(Accepted)
*/

import java.util.Scanner;

public class ex_1000 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		String line = in.nextLine();
		String[] value = line.split( " " );
		int a = Integer.parseInt( value[0] );
		int b = Integer.parseInt( value[1] );
		System.out.println( a + b );
	}
}