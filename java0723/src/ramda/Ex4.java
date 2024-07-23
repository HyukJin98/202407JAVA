package ramda;

public class Ex4 {
	public static void main(String[] args) {
		MyInterface3 ifa = (a,b) -> {
			System.out.println(a+b);
		};
		ifa.method(100,300);
	}
    //매개변수 2개 람다쥐썬더
}
