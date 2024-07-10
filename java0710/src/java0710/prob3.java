package java0710;
import java.util.Scanner;

public class prob3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1, str2;
        int in1 = 0;
        int in2 = 0;

        for(;;) {
        	System.out.print("숫자1을 입력 : ");
        	str1 = scan.nextLine();
        	
        	System.out.print("숫자2을 입력 : ");
        	str2 = scan.nextLine();
        	
        	in1 = Integer.parseInt(str1);
        	in2 = Integer.parseInt(str2);
        	
            if (in1 > in2) {
                System.out.println("두 숫자 중 큰 수는: " + in1);
            } else if (in1 < in2) {
                System.out.println("두 숫자 중 큰 수는: " + in2);
            } else {
                System.out.println(0);
            }
        }
        
        
       

    }
}
