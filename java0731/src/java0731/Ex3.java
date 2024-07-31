package java0731;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Ex3 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길똥",90),
				new Student("강두",93),
				new Student("김똑똑",100)
		);
		System.out.println(list);
		int sum = list.stream().mapToInt(Student::getScore).sum(); //메소드 참조
//		int sum = list.stream().mapToInt(s->s.getScore()).sum();
		System.out.println(sum);
		
		double avg = list.stream().mapToInt(Student::getScore).average().getAsDouble();
		System.out.println(avg);
	}
}
