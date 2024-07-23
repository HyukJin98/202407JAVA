package java0723;

public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	class B{
		void method() {
			field1 = 10;
			method1();
		}
	}
	public static void main(String[] args) {
		System.out.println(A.field2);
//		System.out.println(field1); 객체 생성해야함
	}

}
