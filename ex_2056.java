//2056. Стипендия(Accepted)

import java.util.Scanner;

public class ex_2056 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		int num = in.nextInt();
		int[] array = new int[num];
		for ( int i = 0; i < num; i++ ) {
			array[i] = in.nextInt();
		}
		System.out.println( grant( array ));
	}
	
	public static String grant( int[] mark ) {
		String type = "";
		
		for ( int i = 0; i < mark.length; i++ ) {
			if ( mark[i] == 3 ) {
				return "None";
			}
		}
		
		boolean all5 = true;
		for ( int i = 0; i < mark.length; i++ ) {
			if ( mark[i] != 5 ) {
				all5 = false;
			}
		}
		if ( all5 == true ) {
			return "Named";
		}
		
		double sumScore = 0;
		for ( int i = 0; i < mark.length; i++ ) {
			sumScore += mark[i];
		}
		double avScore = sumScore / mark.length;
		if ( avScore >= 4.5 ) {
			return "High";
		}
		
		return "Common";
	}
}