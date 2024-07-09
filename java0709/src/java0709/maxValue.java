package java0709;
import java.util.Scanner;

public class maxValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstNumber = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondNumber = scanner.nextInt();

      
        if (firstNumber > secondNumber) {
            System.out.println("두 숫자 중 큰 수는: " + firstNumber);
        } else if (firstNumber < secondNumber) {
            System.out.println("두 숫자 중 큰 수는: " + secondNumber);
        } else {
            System.out.println(0);
        }
        
        scanner.close();

    }
}
