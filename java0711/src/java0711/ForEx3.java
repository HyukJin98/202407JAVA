package java0711;
import java.util.Scanner;
public class ForEx3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,w;
		System.out.println("*를 n개 출력하고 w개마다 줄을 바꿔서 출력하는 프로그램");
		
		do{
		System.out.println("n의 값 : ");
		n = sc.nextInt();
		}while(n<=0);
		do{
		System.out.println("w의 값 :");
		w = sc.nextInt();
		}while(w <=0 || w > n);
		
		for(int i=0;i<n;i++) {
			System.out.print("*");
			if(i%w==w-1) {
				System.out.println();
			}
		
	}
		if(n % w != 0) {
			System.out.println();
		}
		System.out.println("완료!");
	}
}
