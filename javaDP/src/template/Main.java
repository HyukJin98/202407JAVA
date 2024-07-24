package template;

public class Main {
	public static void main(String[] args) {
		// H를 가진 CharDisplay 인스턴스를 하나 만든다
		AbstractDisplay d1 = new CharDisplay('H');
		d1.display();
		// 기모찌를 가진 StringDisplay 인스턴스를 하나 만든다
		AbstractDisplay d2 = new StringDisplay("gimochi");
		d2.display();
	}
}