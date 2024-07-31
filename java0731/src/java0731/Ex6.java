package java0731;

import java.util.Arrays;
import java.util.List;

public class Ex6 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("홍길동","신용권","김자바","신용권","신인철");
		
		names.stream().distinct().forEach(n->System.out.println(n)); //중복 제거
		System.out.println();
		names.stream().filter(n->n.startsWith("신")).forEach(n->System.out.println(n));
		System.out.println();
		names.stream().distinct().filter(n->n.startsWith("신")).forEach(n->System.out.println(n));
	}
}
