/*
1203. Научная конференция
*/

import java.util.ArrayList;

class ex_1203 {
	public static void main( String[] args ) {
		int[][] time1 = {
			{ 3, 4 },
			{ 1, 5 },
			{ 6, 7 },
			{ 4, 5 },
			{ 1, 3 },
		};
		
		int[][] time2 = {
			{ 1, 5 },
			{ 2, 5 },
			{ 3, 5 }
		};

		int[][] time3 = {
			{ 1, 8 },
			{ 2, 3 },
			{ 4, 5 },
			{ 6, 7 },
			{ 9, 10 }
		};
		
		int[][] time4 = {
			{ 1, 90 },
			{ 91, 125 },
			{ 129, 200 },
			{ 3, 130 },
			{ 140, 150 },
			{ 160, 162 },
			{ 201, 202 }
		};
		
		int[][] time5 = {
			{ 1, 5 },
			{ 6, 7 },
			{ 2, 3 },
			{ 4, 5 }
		};
		
		getMaxNumOfReports( time1 );
		getMaxNumOfReports( time2 );
		getMaxNumOfReports( time3 );
		getMaxNumOfReports( time4 );
		getMaxNumOfReports( time5 );
	}
	
	public static void getMaxNumOfReports( int[][] time ) {
		ArrayList<Integer> timeA = new ArrayList<Integer>();
		ArrayList<Integer> timeB = new ArrayList<Integer>();
		
		//находим минимальное значение для первой конференции
		int min = time[0][1];
		for ( int i = 0; i < time.length; i++ ) {
			if ( min > time[i][1] ) {
				min = time[i][1];
			}
		}
		
		while ( 1 < 2 ) {
			//заполняем ArrayList A и B интервалами начало которых на 1 больше последнего записанного
			ArrayList<Integer> minA = new ArrayList<Integer>();
			ArrayList<Integer> minB = new ArrayList<Integer>();
			for ( int i = 0; i < time.length; i++ ) {
				if ( timeA.size() == 0 ) {
					if ( time[i][1] == min ) {
						minA.add( time[i][0] );
						minB.add( time[i][1] );
					}
				} else {
					if ( time[i][0] - timeB.get( timeB.size() - 1 ) >= 1 ) {
						minA.add( time[i][0] );
						minB.add( time[i][1] );
					}
				}
			}
			
			//находим наименьший интервал
			int index = 0;
			for ( int i = 0; i < minB.size(); i++ ) {
				if ( minB.get( i ) < minB.get( index )) {
					index = i;
				}
			}
			
			//завершаем поиск если нет больше вариантов
			if ( minB.size() == 0 ) {
				break;
			}
			
			//добавляем интервал
			timeA.add( minA.get( index ));
			timeB.add( minB.get( index ));
			
			System.out.print( minA.get( index ) + "-" + minB.get( index ) + " " );
		}
		
		System.out.println( "\nMaximum number of reports: " + timeA.size());
	}
}