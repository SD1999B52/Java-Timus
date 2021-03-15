//1083. Факториалы!!!
class ex_1083 {
	public static void main( String[] args ) {
		int n = 9, k = 1;
		int res = n, l = 1;
		
		if ( n % k == 0 ) {
			l = k;
		}
		
		for ( int i = 1; n - k * i > l; i++ ) {
			res *= n - k * i;
		}
		System.out.println( res );
	}
}