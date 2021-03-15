//1567. SMS-спам
class ex_1567 {
	public static void main( String[] args ) {
		String text = "pokupaite gvozdi tolko v kompanii gvozdederov i tovarischi!";
		char[][] array = {
			{ '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '#' },
			{ 'a', 'd', 'g', 'j', 'm', 'p', 's', 'v', 'y', '.', ' ' },
			{ 'b', 'e', 'h', 'k', 'n', 'q', 't', 'w', 'z', ',', '-' },
			{ 'c', 'f', 'i', 'l', 'o', 'r', 'u', 'x', '-', '!', '-' },
		};
		
		int amount = 0;
		for ( int index = 0; index < text.length(); index++ ) {
			for ( int i = 1; i < array.length; i++ ) {
				for ( int i2 = 0; i2 < array[0].length; i2++ ) {
					if ( text.charAt( index ) == array[i][i2] ) {
						amount += i;
					}
				}
			}
		}
		System.out.println( amount );
	}
}