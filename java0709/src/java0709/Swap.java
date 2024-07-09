package java0709;

public class Swap {
	
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		
		System.out.printf("x=%d\n", x);
		System.out.printf("y=%d\n", y);
		
		int temp = x;
		x = y;
		y = temp;
		
		System.out.printf("x=%d\n", x);
		System.out.printf("y=%d", y);
		
	}

}
