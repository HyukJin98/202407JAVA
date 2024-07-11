package java0711;
import java.util.Scanner;

public class factorial {
	 public static long factorial(int n) {
	        if (n == 0) {
	            return 1; 
	        } else {
	            return n * factorial(n - 1);
	        }
	        
	    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("팩토리얼 출력 프로그램");
		boolean run = true;
		int number;
	    long result;
		
		 while(run){System.out.print("정수 입력 : ");
        number = sc.nextInt();
        result = factorial(number);
        System.out.println(number + "! = " + result);
		}
        
    }

}
