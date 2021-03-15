//1607. Такси
class ex_1607 {
	public static void main( String[] args ) {
		int a = 150, b = 50;
		int c = 1000, d = 100;
		
		while ( a <= c ) {
			a = a + b;
			c = c - d;
			System.out.println( "P=" + a + " T=" + c );
		}
		System.out.println( a );
	}
}