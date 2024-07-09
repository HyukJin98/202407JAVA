package java0709;
import java.util.Scanner;
public class maxValue2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력 :");
		int firstNumber = scan.nextInt();
		
		System.out.print("두번째 정수 입력 :");
		int secondNumber = scan.nextInt();
		
		System.out.print("세번째 정수 입력 :");
		int thirdNumber = scan.nextInt();
		
		if(firstNumber > thirdNumber) {
			System.out.println(firstNumber);
		}
		else if(secondNumber > thirdNumber) {
			System.out.println(secondNumber);
		}
		else {
			System.out.println(thirdNumber);
		}
	}

}
