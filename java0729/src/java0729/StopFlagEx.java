package java0729;

public class StopFlagEx {
	public static void main(String[] args) {
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		printThread.setStop(true);
	}
}
