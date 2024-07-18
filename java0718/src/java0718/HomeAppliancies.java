package java0718;

public abstract class HomeAppliancies {
	int serialNo;
	String manufacture;
	int year;
	
	void turnOn() {
		System.out.println("기기 작동");
	}
	void turnOff() {
		System.out.println("기기 멈춤");
		
	}

}
