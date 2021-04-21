//1120. Сумма последовательных чисел(Accepted)
//Задача сводится к решению уравнения (P-1)*(P+2)*A = 2*N в целых положительных числах
//первый вариант не укладывается по времени

import java.util.Scanner;

public class ex_1120 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		int N = in.nextInt();
		
		/*
		for ( int A = 1; 1 < 2; A++ ) {
			int sum = 0;
			int P = 0;
			for ( int i = 0; sum < N; i++ ) {
				sum += A + i;
				P += 1;
				//System.out.print(( A + i ) + " " );
				if ( sum == N ) {
					System.out.println( A + " " + P );
					return;
				}
			}
			//System.out.println();
		}
		*/
		
		int saveA = 0, saveP = 0;
		for ( int P = 1; N / P > ( P - 1 ) / 2; P++ ) {
			if (( N * 2 - P * ( P - 1 )) % ( P * 2 ) == 0 ) {
				int A = ( N * 2 - P * ( P - 1 )) / ( P * 2 );
				if ( P > saveP ) {
					saveA = A;
					saveP = P;
				}
			}
		}
		System.out.println( saveA + " " + saveP );
	}
}