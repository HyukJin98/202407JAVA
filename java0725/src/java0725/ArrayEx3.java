package java0725;

import java.util.Arrays;

public class ArrayEx3 {
	public static void main(String[] args) {
		int[] array = {1,1,4,3,12,56,43,2,5,4};
		int[] array2 = {1,2,3,4,5,10};
		int found = Arrays.binarySearch(array, 5);
		int found2 = Arrays.binarySearch(array2, 5);//정렬이 된 상태만 가능
		System.out.println(found);
		System.out.println(found2);
	}
}
