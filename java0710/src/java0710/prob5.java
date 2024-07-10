package java0710;
import java.util.Scanner;
public class prob5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
/*		int in = 90;
		String score2 = (in >= 90) ? "A" : 
			             (in >= 80) ? "B" : 
			            	(in >= 70) ? "C" :
			            		(in >= 60) ? "D" : "F";
		System.out.println(score2); */
		
		System.out.print("점수를 입력 : ");
		int i = sc.nextInt();
		String score = "";
		switch(i/10){
		case 10:
		case 9: score = "A";
		break;
		case 8: score = "B";
		break;
		case 7: score = "C";
		break;
		case 6: score = "D";
		break;
		default: score = "F";
		break;
		}
		System.out.println(score);
	}

}
