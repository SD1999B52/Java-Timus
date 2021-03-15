//1296. Гиперпереход
class ex_1296 {
	public static void main( String[] args ) {
		int[] data1 = { 10, 31, -41, 59, 26, -53, 58, 97, -93, -23, 84 };
		int[] data2 = { 3, -1, -5, -6 };
		System.out.println( MaxGravPot( data1 ));
		System.out.println( MaxGravPot( data2 ));
	}
	
	public static int MaxGravPot( int[] data ) {
		int sum = 0, answer = 0;
		for ( int i = 1; i < data.length; i++ ) {
			sum += data[i];
			if ( sum < 0 ) {
				sum = 0;
			}
			if ( sum > answer ) {
				answer = sum;
			}
		}
		return answer;
	}
}