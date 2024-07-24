package singleton;

public class Main {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		if(obj1 == obj2) {
			System.out.println("같은 인스턴스임다");
		}
		else {
			System.out.println("같은 인스턴스가 아임다");
		}
	}
}
