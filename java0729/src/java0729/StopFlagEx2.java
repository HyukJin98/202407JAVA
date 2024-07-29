package java0729;

public class StopFlagEx2 {
	public static void main(String[] args) {
		PrintThread2 printThread2 = new PrintThread2();
		printThread2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
		}
		printThread2.interrupt();
	}
}
