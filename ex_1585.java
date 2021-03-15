//1585. Пингвины
class ex_1585 {
	public static void main( String[] args ) {
		String[] array = {
			"Emperor Penguin",
			"Macaroni Penguin",
			"Little Penguin",
			"Emperor Penguin",
			"Macaroni Penguin",
			"Macaroni Penguin",
			"Little Penguin"
		};
		
		String[] types = {
			"Emperor Penguin",
			"Macaroni Penguin",
			"Little Penguin"
		};
		
		int[] num = new int[types.length];
		for ( int i = 0; i < types.length; i++ ) {
			for ( int i2 = 0; i2 < array.length; i2++ ) {
				if ( types[i].equals( array[i2] ) == true ) {
					num[i] += 1;
				}
			}
		}
		
		int idMax = 0;
		for ( int i = 0; i < num.length; i++ ) {
			if ( num[idMax] < num[i] ) {
				idMax = i;
			}
		}
		System.out.println( types[idMax] );
	}
}