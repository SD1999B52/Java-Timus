//1203. Научная конференция(не укладывается по времени)

import java.util.ArrayList;
import java.util.Scanner;

public class ex_1203 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		int num = Integer.parseInt( in.nextLine());
		int[][] time = new int[num][2];
		
		for ( int i = 0; i < num; i++ ) {
			String line = in.nextLine();
			String[] value = line.split( " " );
			time[i][0] = Integer.parseInt( value[0] );
			time[i][1] = Integer.parseInt( value[1] );
		}
		
		getMaxNumOfReports( time );
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
		}
		
		System.out.println( timeS.size());
	}
}
