package java0725;
class Parent{
	

	void method() {
		
	}
}

public class Ex1 {
	public static void main(String[] args) {
		Parent parent = new Parent() {
			void method2() {
				System.out.println("오직 나만");
			}
			void method() {
				System.out.println("난 익명 자식 개체");
				super.method();
				method2();
			}
		};
	}
}
