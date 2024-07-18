package java0718;

public class Ex2 {
	public static void main(String[] args) {
		HomeAppliancies ws = new Washer();
		HomeAppliancies fr = new Freezer();
		HomeAppliancies dw = new DishWasher();
		
		ws.turnOn();
		ws.turnOff();
		
		fr.turnOn();
		fr.turnOff();
		
		dw.turnOn();
		dw.turnOff();
		
		
	}

}
