package java0710;

import java.util.Scanner;

public class prob4 {
	
	public static int Max(int x,int y,int z) {
		int max = x;
		if(y > max) {
			max = y;
		}
		if(z > max) {
			max = z;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("3개의 수를 입력: ");
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		System.out.println(Max(a,b,c));
	}

}
