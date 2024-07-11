package java0711;

public class Max {
	public static void main(String[] args) {
		int a[] = {1, 23, 10, 223, 811};
		int i;
		int max = a[0];
		
		for(i = 1;i<a.length;i++) {
			if(max < a[i]) {
				max = a[i];
			}
		}
		System.out.println("최대값 : " + max);
		
	}

}
