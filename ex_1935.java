//1935. Слёзы утопленников(Accepted)

import java.util.Scanner;

public class ex_1935 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		int num = Integer.parseInt( in.nextLine());
		int[] array = new int[num];
		String[] values = in.nextLine().split( " " );
		for ( int i = 0; i < num; i++ ) {
			array[i] = Integer.parseInt( values[i] );
		}
		
		int max = array[0];
		for ( int i = 1; i < array.length; i++ ) {
			if ( max < array[i] ) {
				max = array[i];
			}
		}
		
		int sum = 0;
		for ( int i = 0; i < array.length; i++ ) {
			sum += array[i];
		}
		
		int sheets = sum + max;
		
		System.out.println( sheets );
	}
}