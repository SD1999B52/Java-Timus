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
		ArrayList<int[]> timeS = new ArrayList<int[]>();
		
		//находим минимальное значение для первой конференции
		int min = time[0][1];
		for ( int i = 0; i < time.length; i++ ) {
			if ( min > time[i][1] ) {
				min = time[i][1];
			}
		}
		
		while ( 1 < 2 ) {
			//заполняем ArrayList A и B интервалами начало которых на 1 больше последнего записанного
			ArrayList<int[]> minS = new ArrayList<int[]>();
			
			for ( int i = 0; i < time.length; i++ ) {
				if ( timeS.size() == 0 ) {
					if ( time[i][1] == min ) {
						minS.add( new int[] { time[i][0], time[i][1] } );
					}
				} else {
					if ( time[i][0] - timeS.get( timeS.size() - 1 )[1] >= 1 ) {
						minS.add( new int[] { time[i][0], time[i][1] } );
					}
				}
			}
			
			//находим наименьший интервал
			int index = 0;
			for ( int i = 0; i < minS.size(); i++ ) {
				if ( minS.get( i )[1] < minS.get( index )[1] ) {
					index = i;
				}
			}
			
			//завершаем поиск если нет больше вариантов
			if ( minS.size() == 0 ) {
				break;
			}
			
			//добавляем интервал
			timeS.add( new int[] { minS.get( index )[0], minS.get( index )[1] } );
			
			System.out.print( minS.get( index )[0] + "-" + minS.get( index )[1] + " " );
		}
		
		System.out.println( "\nMaximum number of reports: " + timeS.size());
	}
}