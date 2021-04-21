//1139. Городские кварталы(Accepted)

import java.util.Scanner;

public class ex_1139 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		String line = in.nextLine();
		String[] value = line.split( " " );
		
		int n = Integer.parseInt( value[0] );
		int m = Integer.parseInt( value[1] );
		int quarterX = ( n - 1 );
		int quarterY = ( m - 1 );
		int answer = quarterX + quarterY - HCF( quarterX, quarterY );
		System.out.println( answer );
	}
	
	//Алгоритм Евклида
	public static int HCF( int a, int b ) {
		while ( b != 0 ) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}