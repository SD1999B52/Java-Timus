class ex_1712 {
	public static void main( String[] args ) {
		String[][] lattice = {
			{ ".", ".", ".", "." },
			{ "X", ".", ".", "X" },
			{ ".", "X", ".", "." },
			{ ".", ".", ".", "X" }
		};
		
		String[][] key = {
			{ "P", "w", "o", "o" },
			{ "K", "h", "a", "a" },
			{ "s", "m", "r", "s" },
			{ "o", "d", "b", "k" }
		};
		
		String text = "";
		for ( int ri = 0; ri < key.length; ri++ ) {
			for ( int i = 0; i < key.length; i++ ) {
				for ( int i2 = 0; i2 < key[0].length; i2++ ) {
					if ( lattice[i][i2].equals( "X" ) == true ) {
						text += key[i][i2];
					}
				}
			}
			lattice = rotateArray( lattice );
		}
		System.out.println( text );
	}
	
	public static String[][] rotateArray( String[][] array ) {
		String[][] newarray = new String[array.length][array[0].length];
		for ( int i = 0; i < array.length; i++ ) {
			for ( int i2 = 0; i2 < array[0].length; i2++ ) {
				newarray[i2][array[0].length - 1 - i] = array[i][i2];
			}
		}
		return newarray;
	}
}