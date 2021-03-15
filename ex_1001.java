//1001. Обратный корень
class ex_1001 {
	public static void main( String[] args ) {
		long[] array = new long[] { 1427L, 0L, 876652098643267843L, 5276538L };
		for ( int i = 0; i < array.length; i++ ) {
			System.out.println( String.format( "%.4f", Math.sqrt( array[i] )));
		}
	}
}