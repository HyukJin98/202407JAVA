package java0730;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Ex6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("카운트 입력 : ");
		int count = sc.nextInt();
		int sum = 0;
		sum = IntStream.rangeClosed(1, count).sum();
//		IntStream ii2 = IntStream.rangeClosed(1, 5); 1부터 5까지 출력
//		ii.forEach(System.out::println);
		System.out.println(sum);
		
		
	}
}
