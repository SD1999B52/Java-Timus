//1404. Легко взломать!
class ex_1404 {
	public static void main( String[] args ) {
		String text = "secret";
		String code = "";
		String decode = "";
		
		//туда
		int[] codes = new int[text.length()];
		for ( int i = 0; i < text.length(); i++ ) {
			codes[i] = (int)( text.charAt( i )) - 97;
			if ( i == 0 ) {
				codes[0] += 5;
			} else {
				codes[i] += codes[i - 1];
			}
			if ( codes[i] > 25 ) {
				codes[i] %= 26;
			}
			code += (char)( codes[i] + 97 );
		}
		
		//обратно
		int temp = 0;
		for ( int i = 0; i < code.length(); i++ ) {
			if ( i == 0 ) {
				temp = (int)( code.charAt( i )) - 97 - 5;
			} else {
				temp = (int)( code.charAt( i )) - (int)( code.charAt( i - 1 ));
			}
			if ( temp < 0 ) {
				temp += 26;
			}
			decode += (char)( temp + 97 );
		}
		
		System.out.println( code );
		System.out.println( decode );
	}
}