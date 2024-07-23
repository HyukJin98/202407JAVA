package ramda;

public class Ex5 {
	public static void main(String[] args) {
		MyInterface4 ifa4 = (a,b)->{return a+b;};
		
		
		int x = ifa4.method(100, 700);
		System.out.println(x);
	}
	
}
