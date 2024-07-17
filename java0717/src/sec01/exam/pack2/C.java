package sec01.exam.pack2;
import sec01.exam.pack1.*;
public class C extends A{
	public void method() {
		this.field = "val";
		this.method();
	}

}
