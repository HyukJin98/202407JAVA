package java0710;

public class prob10 {
	public static void main(String[] args) {
		int i;
		int sum = 0;
		for (i=2;i<=100;i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
