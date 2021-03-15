//1935. Слёзы утопленников
class ex_1935 {
	public static void main( String[] args ) {
		int[] array = { 5, 10, 3 };
		
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