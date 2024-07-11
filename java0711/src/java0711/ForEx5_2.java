package java0711;
import java.util.Scanner;
public class ForEx5_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("+와 -를 번갈아 n개 출력합니다.");
		
		do {
			System.out.print("n의 값 : ");
			n = sc.nextInt();
			sc.close();
		}while(n <= 0);
		
		for(int i=0; i< n/2; i++) {
			System.out.print("+-");
		}
		if(n % 2 !=0) { 
			System.out.print("+");
		}
		
		}
		
	}


