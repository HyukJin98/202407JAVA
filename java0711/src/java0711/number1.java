package java0711;
import java.util.Scanner;
public class number1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("2자리 양수를 입력받는 프로그램");
		int no;
		do {
			System.out.println("no값:");
			no = sc.nextInt();
		}while(no < 10 || no > 99);
		
		System.out.println("변수 no값은 " + no + " 입니다.");
	}
}
