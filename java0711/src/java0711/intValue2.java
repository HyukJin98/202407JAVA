package java0711;
import java.util.Scanner;

public class intValue2 {
	public static int sumOf(int a,int b) {
		int min;
		int max;
		
		if(a < b) {
			min = a; max = b;
		}
		else {
			min = b; max = a;
		}
		
		int sum = 0;
		for(int i=min;i<=max;i++) {
			sum += i;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("a 부터 b까지의 합을 구하는 프로그램");
		
		System.out.println("a 값: ");
		int a = sc.nextInt();
		System.out.println("b 값: ");
		int b = sc.nextInt();
		
		System.out.println(a + " 부터 " + b + " 까지의 합은 " + sumOf(a,b) + " 입니다.");
		
	}

}
