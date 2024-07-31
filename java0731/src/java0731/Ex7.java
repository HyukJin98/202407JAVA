package java0731;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Ex7 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
//		double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
//		System.out.println(avg);
		OptionalDouble avg = list.stream().mapToInt(Integer::intValue).average();
		if(avg.isPresent()) {
			System.out.println(avg.getAsDouble());
		}
		else {
			System.out.println("값이 없다");
		}
		double avg1 = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		System.out.println(avg);
		System.out.println(avg1);
		
		list.stream().mapToInt(Integer::intValue).average().ifPresent(a->{
			System.out.println(a);
		});
	}
}
