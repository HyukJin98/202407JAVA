package java0712;

public class Factorial1 {
	public static int fac2(int n) {
		if(n == 0) {
			return 1;
		}
		else {
			return (n) * fac2(n-1);
		}
	}
	public static int fac(int n) {
		int res = 1;
		for(int i=1;i<=n;i++) {
			res *= i;
		}
		return res;
	}

	public static void main(String[] args) {
		int num = 4;
		int result = fac2(num);
		System.out.println(result);
	}
}
