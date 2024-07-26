package java0725;

import java.util.Arrays;
import java.util.Comparator;

public class StudentEx {
	public static void main(String[] args) {
		Student[] students = {
				new Student("홍킬동",97),
				new Student("홍길똥",100),
				new Student("홍길동",75),
				new Student("기모찌",80),
				new Student("이혓진",10)
		};
		
		Comparator<Student> c = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				
				return Integer.compare(o2.getScore(),o1.getScore());
			}
		};
		
		Arrays.sort(students,c);
		for(Student st : students) {
			System.out.println(st);
		}
	}
}
