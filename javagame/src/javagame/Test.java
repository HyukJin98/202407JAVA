package javagame;

public class Test {
	public static void main(String[] args) {
		int random[] = {(int)(Math.random() * 45)+1,(int)(Math.random() * 45)+1,(int)(Math.random() * 45)+1,(int)(Math.random() * 45)+1,(int)(Math.random() * 45)+1,(int)(Math.random() * 45)+1};
		for(int i = 0; i< 6; i++) {
			System.out.println(random[i]);
		}
	}
}
