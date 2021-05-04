//1002. Телефонные номера(Accepted)

import java.util.Scanner;
import java.util.ArrayList;

public class ex_1002 {
	static char[][] array = {
		{ 'o', 'i', 'a', 'd', 'g', 'k', 'm', 'p', 't', 'w' },
		{ 'q', 'j', 'b', 'e', 'h', 'l', 'n', 'r', 'u', 'x' },
		{ 'z', '-', 'c', 'f', '-', '-', '-', 's', 'v', 'y' }
	};
	
	public static void main( String[] args ) {
		ArrayList<String> answer = new ArrayList<String>();
		Scanner in = new Scanner( System.in );
		String number = "";
		while ( 1 < 2 ) {
			//получаем номер
			number = in.nextLine();
			if ( number.equals( "-1" ) == true ) {
				break;
			}

			//получаем количество строк текста
			int lineNum = Integer.parseInt( in.nextLine());
			
			//получаем строки текста
			ArrayList<String> data = new ArrayList<String>();
			for ( int i = 0; i < lineNum; i++ ) {
				String text = in.nextLine();
				data.add( text );
			}
			
			//создаём матрицу ( n + 1 ) x ( n + 1 )
			int[][] graph = new int[number.length() + 1][number.length() + 1];
			for ( int i = 0; i < graph.length; i++ ) {
				for ( int i2 = 0; i2 < graph[0].length; i2++ ) {
					graph[i][i2] = -1;
				}
			}
			
			//заполняем матрицу
			for ( int i = 0; i < data.size(); i++ ) {
				String inData = convertText( data.get( i ));
				for ( int i2 = 0; i2 <= number.length() - inData.length(); i2++ ) {
					String inNumber = number.substring( i2, i2 + inData.length());
					if ( inData.equals( inNumber ) == true ) {
						graph[i2][i2 + inData.length()] = i;
					}
				}
			}
			
			//сохранение вершин пути
			int[][] vertex = new int[number.length() + 1][3];
			for ( int i = 0; i < vertex.length; i++ ) {
				vertex[i][0] = -1;
				vertex[i][1] = -1;
				vertex[i][2] = -1;
			}
			
			//начальная вершина
			for ( int i = 0; i < vertex[0].length; i++ ) {
				vertex[0][i] = 0;
			}
			
			//стек для BFS
			ArrayList<Integer> stack = new ArrayList<Integer>();
			stack.add( 0 );
			//BFS
			while ( stack.size() != 0 ) {
				int top = stack.get( stack.size() - 1 );
				stack.remove( stack.size() - 1 );
				int newWeight = vertex[top][0] + 1;
				
				for ( int i = top + 1; i < number.length() + 1; i++ ) {
					if ( graph[top][i] > -1 ) {
						
						if (( vertex[i][0] > newWeight ) | ( vertex[i][0] == -1 )) {
							if ( vertex[i][1] == -1 ) {
								stack.add( i );
							}
							
							vertex[i][0] = newWeight;
							vertex[i][1] = top;
							vertex[i][2] = graph[top][i];
						}
					}
				}
			}
			
			if ( vertex[number.length()][1] == -1 ) {
				System.out.println( "No solution." );
			} else {
				String text = "";
				int position = number.length();
				while ( position != 0 ) {
					if ( text.equals( "" ) == true ) {
						text = data.get( vertex[position][2] ) + text;
					} else {
						text = data.get( vertex[position][2] ) + " " + text;
					}
					position = vertex[position][1];
				}
				answer.add( text );
			}
		}
		for ( int i = 0; i < answer.size(); i++ ) {
			System.out.println( answer.get( i ));
		}
	}
	
	//преобразование текста в цифры
	public static String convertText( String text ) {
		String convert = "";
		for ( int i2 = 0; i2 < text.length(); i2++ ) {
			char character = text.charAt( i2 );
			for ( int i3 = 0; i3 < array[0].length; i3++ ) {
				for ( int i4 = 0; i4 < array.length; i4++ ) {
					if ( character == array[i4][i3] ) {
						convert += Integer.toString( i3 );
					}
				}
			}
		}
		return convert;
	}
}

/*
It's not so interesting to publish ready code, but for those who stuck on this problem the following algorithm could be useful:
1. First of all, build generator, that will generate random tests with specified phone number length and number of words. It will
helpful, since you don't know, which tests are runned when you send you code for check.

2. Convert your words to digits and remove those of them that aren't contained in phone number. Also remove duplications that can
appear after this converting. During this process build dictionary that will contain converted word as a key, and original word as
a value. Last one will be needed to output the result.

3. Sort converted words by length in descendent order.

4. Take every converted word and find all its inclusions to the phone number. Build dictionary that will contain found index as
key and list of converted words as value.

5. Now use recursive function which initially will get index=0 as argument, find all words from dictionary for the index and loop
them, taking their length to get next index.
If next index equals phone number length, you found one of the solutions.

6. Optimize the function to eleminate redundant calls. I mean, on specific step you can check if the next searched solution is
expected to be better than found one or not.

I'm not sure that this algorithm is the best, but at least I got "accepted" on C# with 600 ms performance.
*/

/*
Публиковать готовый код не так интересно, но тем, кто застрял на этой проблеме, может быть полезен следующий алгоритм:

1. Прежде всего, построить генератор, который будет генерировать случайные тесты с заданной длиной телефонного номера и количеством
слов. Это будет полезно, поскольку вы не знаете, какие тесты запускаются, когда вы отправляете код для проверки.

2. Преобразуйте свои слова в цифры и удалите те из них, которых нет в номере телефона. Также удалите дубликаты, которые могут
появиться после этого преобразования. Во время этого процесса создайте словарь, который будет содержать преобразованное слово в качестве
ключа и исходное слово в качестве значения. Последний понадобится для вывода результата.

3. Отсортируйте преобразованные слова по длине в порядке убывания.

4. Возьмите каждое преобразованное слово и найдите все его включения в номер телефона. Создать словарь, который будет содержать
найденный индекс в качестве ключа и список преобразованных слов в качестве значения.

5. Теперь используйте рекурсивную функцию, которая изначально получит index = 0 в качестве аргумента, найдите все слова из словаря
для индекса и зациклируйте их, взяв их длину, чтобы получить следующий индекс.
Если следующий индекс равен длине телефонного номера, вы нашли одно из решений.

6. Оптимизируйте функцию, чтобы исключить избыточные вызовы. Я имею в виду, что на конкретном этапе вы можете проверить, будет ли
следующее искомое решение лучше, чем найденное, или нет.

Я не уверен, что этот алгоритм лучший, но, по крайней мере, меня "приняли" на C # с производительностью 600 мс.
*/
