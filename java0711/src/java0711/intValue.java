package java0711;
import java.util.Scanner;
public class intValue {
	public static int middle(int x,int y, int z) {
		if((y >= x && z <= x)||(y <= x && z >= x)) {
			return x;
		}
		else if((x > y && z < y)||(x < y && z > y)) {
			return y;
		}
			return z;
			
/*		if(x >= y) {
			if(y >= z) {
				return y;
			}
			else if(x <= z) {
				return x;
			}
			else {
				return z;
			}
		}
		else if(x > z) {
			return x;
		}
		else if(y > z) {
			return z;
		}
		else {
			return y; 
		} */
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("세 정수 중 중앙값 출력 ");
		System.out.println("첫번째 정수값:");
		int x = sc.nextInt();
		System.out.println("두번째 정수값:");
		int y = sc.nextInt();
		System.out.println("세번째 정수값:");
		int z = sc.nextInt();
		
		System.out.println("중앙값은 " + middle(x,y,z) + "입니다.");
		
		
/*		if(x >= y) {
			if(y >= z) {
				System.out.println(y);
			}
			else if(x <= z) {
				System.out.println(x);
			}
			else {
				System.out.println(z);
			}
		}
		else if(x > z) {
			System.out.println(x);
		}
		else if(y > z) {
			System.out.println(z);
		}
		else {
			System.out.println(y);
		}
	*/	
		
	}

}
