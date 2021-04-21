//2002. Тестовое задание(Accepted)

import java.util.ArrayList;
import java.util.Scanner;

public class ex_2002 {
	static ArrayList<String> data = new ArrayList<String>();
	
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		int num = Integer.parseInt( in.nextLine());
		String[] querys = new String[num];
		for ( int i = 0; i < num; i++ ) {
			querys[i] = in.nextLine();
		}
		/*
		String[] querys = {
			"register vasya 12345",
			"login vasya 1234",
			"login vasya 12345",
			"login anakin C-3PO",
			"logout vasya",
			"logout vasya"
		};
		*/
		for ( int i = 0; i < querys.length; i++ ) {
			String command = getSplitQuery( querys[i], 0 );
			
			if ( command.equals( "register" ) == true ) {
				String name = getSplitQuery( querys[i], 1 );
				if ( userExists( name ) == false ) {
					String password = getSplitQuery( querys[i], 2 );
					data.add( name + " " + password + " " + "0" );
					System.out.println( "success: new user added" );
				} else {
					System.out.println( "fail: user already exists" );
				}
			}
			
			if ( command.equals( "login" ) == true ) {
				String name = getSplitQuery( querys[i], 1 );
				if ( userExists( name ) == true ) {
					String password = getSplitQuery( querys[i], 2 );
					if ( correctPassword( name, password ) == true ) {
						if ( userOnline( name ) == false ) {
							userInOut( name, "1" );
							System.out.println( "success: user logged in" );
						} else {
							System.out.println( "fail: already logged in" );
						}
					} else {
						System.out.println( "fail: incorrect password" );
					}
				} else {
					System.out.println( "fail: no such user" );
				}
			}
			
			if ( command.equals( "logout" ) == true ) {
				String name = getSplitQuery( querys[i], 1 );
				if ( userExists( name ) == true ) {
					if ( userOnline( name ) == true ) {
						userInOut( name, "0" );
						System.out.println( "success: user logged out" );
					} else {
						System.out.println( "fail: already logged out" );
					}
				} else {
					System.out.println( "fail: no such user" );
				}
			}
		}
	}
	
	public static void userInOut( String name, String mode ) {
		for ( int i = 0; i < data.size(); i++ ) {
			if ( getSplitQuery( data.get( i ), 0 ).equals( name ) == true ) {
				String password = getSplitQuery( data.get( i ), 1 );
				data.set( i, name + " " + password + " " + mode );
			}
		}
	}
	
	public static boolean userOnline( String name ) {
		for ( int i = 0; i < data.size(); i++ ) {
			if ( getSplitQuery( data.get( i ), 0 ).equals( name ) == true ) {
				if ( getSplitQuery( data.get( i ), 2 ).equals( "1" ) == true ) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean correctPassword( String name, String password ) {
		for ( int i = 0; i < data.size(); i++ ) {
			if ( getSplitQuery( data.get( i ), 0 ).equals( name ) == true ) {
				if ( getSplitQuery( data.get( i ), 1 ).equals( password ) == true ) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean userExists( String name ) {
		for ( int i = 0; i < data.size(); i++ ) {
			if ( getSplitQuery( data.get( i ), 0 ).equals( name ) == true ) {
				return true;
			}
		}
		return false;
	}
	
	public static String getSplitQuery( String query, int numSpace ) {
		String word = "";
		for ( int i = 0; i < query.length(); i++ ) {
			if (( query.charAt( i ) == ' ' ) & ( numSpace == 0 )) {
				break;
			}
			if (( query.charAt( i ) != ' ' ) & ( numSpace == 0 )) {
				word += query.charAt( i );
			}
			if (( query.charAt( i ) == ' ' ) & ( numSpace != 0 )) {
				numSpace -= 1;
			}
		}
		return word;
	}
}