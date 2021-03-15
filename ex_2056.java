//2056. Стипендия
class ex_2056 {
	public static void main( String[] args ) {
		int[] array1 = { 5, 5, 4 };
		int[] array2 = { 3, 3, 3 };
		
		System.out.println( grant( array1 ));
		System.out.println( grant( array2 ));
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
		double avScore = sumScore / ( mark.length - 1 );
		if ( avScore >= 4.5 ) {
			return "High";
		}
		
		return "Common";
	}
}