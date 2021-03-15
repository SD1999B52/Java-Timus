//1120. Сумма последовательных чисел
class ex_1120 {
	public static void main( String[] args ) {
		int n = 140;
		
		int sum = 0, a = 0, P = 0;
		while ( sum < n ) {
			P += 1;
			sum += a + P;
			if ( sum > n ) {
				sum = 0;
				P = 0;
				a += 1;
			}
		}
		int A = a + 1;
		System.out.println( "A: " + A + " P: " + P );
	}
}