package java0711;

public class Min {
	public static void main(String[] args) {
		int a[]= {5,10,3,1,50};
		int min = a[0];
		
		for(int i=1;i<a.length;i++) {
			if(a[i]<min) {
				min = a[i];
			}
		}
		System.out.println("최솟값 : " + min);
	}

}
