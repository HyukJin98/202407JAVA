package java0718;

public class Ex4 {
	public static void main(String[] args) {
		impleC imc = new impleC();
		
		InterA ia = imc;
		ia.methodA();
		
		InterB ib = imc;
		ib.methodB();
		
		InterC ic = imc;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}

}
