package ramda;

public class Ex3 {
	public static void main(String[] args) {
		MyInterface2 ifa = (a) -> {
			System.out.println(a+300);
		};
		ifa.method(100);
	}
	//매개변수 1개 람다쥐썬더
}
