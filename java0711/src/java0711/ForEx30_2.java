package java0711;
import java.util.Scanner;
public class ForEx30_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x;
		System.out.println("1부터 n까지의 합 구하는 프로그램");
		do{
	     	System.out.println("n 값 입력 :");
	     	x = sc.nextInt();
		}while(x<=0);
		
		int sum = 0;
		for(int i = 1; i<x; i++) {
			System.out.print(i +"+");
			sum += i;
		}
		
		System.out.print(x + "=");
		sum += x;
		System.out.println(sum);
	}

}
