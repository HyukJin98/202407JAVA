package java0710;

public class Ex2 {
	public static void main(String[] args) {
		int in = 90;
		String score = (in >= 90) ? "A" : 
			             (in >= 80) ? "B" : 
			            	(in >= 70) ? "C" :
			            		(in >= 60) ? "D" : "F";
		System.out.println(score);
		
		int c1 = 'A';
		
		if((c1>=65 & (c1<=90))) {
			System.out.println("대문자군요");
		}
		String str1 = "가나다";
		String str2 = "가나다";
		boolean result2 = str1.equals(str2);
		System.out.println(result2);
		
		int num1 = 10;
		int num2 = 10;
		boolean result1 = num1 == num2;
		System.out.println(result1);
		int x = 0;
//		int y = ++x;
		int y = x++;
//		++x;
		System.out.println(x);
		System.out.println(y);
		
	}

}
