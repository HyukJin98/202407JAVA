package java0709;
import java.util.Scanner;

public class intSwap {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 :");
		int number = scan.nextInt();
		
		if(number > 0) {
			System.out.println(number);
		}
		else {
			System.out.println(number * -1);
		}
	}

}
