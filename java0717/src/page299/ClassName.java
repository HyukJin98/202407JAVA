package page299;

public class ClassName {
	
	int field1;
	void method1() {
		field2 = 200;
		this.field1 = 300;
	}
	
	static int field2;
	static void method2() {
		field2 = 10;
	}
	
	static void method3() {
		ClassName obj = new ClassName();
		obj.field1 = 10;
		obj.method1();
		field2 = 10;
		ClassName.method2();
		System.out.println(ClassName.field2);
	}
}
