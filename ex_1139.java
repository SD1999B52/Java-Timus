//1139. Городские кварталы
class ex_1139 {
	public static void main( String[] args ) {
		int n = 4, m = 3;
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