package java0712;
import java.util.Scanner;
public class Ex7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 입력 : ");
		int mn = Integer.parseInt(sc.nextLine());
	    double scores[][] = new double[mn][3]; //국, 수, 평균
	    
	    for(int i = 0; i< scores.length;i++) {
	    	System.out.print(i+1 + "번 학생 ");
	    	System.out.print("국어 점수 : ");
	    	scores[i][0] = Double.parseDouble(sc.nextLine());
	    	
	    	System.out.print(i+1 + "번 학생 ");
	    	System.out.print("수학 점수 : ");
	    	scores[i][1] = Double.parseDouble(sc.nextLine());
	    	
	    	scores[i][2] = (scores[i][0] + scores[i][1]) / 2; //평균
	    
	    	
	    }
        
	    System.out.printf("\t\t국어\t\t수학\t\t평균\n");
	    System.out.println("================================================================");
	    for(int i = 0; i< scores.length;i++) {
	    	System.out.printf("%d번 학생\t %f\t %f\t %f\t\n",i+1,scores[i][0],scores[i][1],scores[i][2]);
	      
	    }
	    
	    
	    
	}

}
