package java0725;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentEx2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍킬동",60));
		list.add(new Student("기모찌",78));
		list.add(new Student("자르반 84세",32));
		list.add(new Student("냥냥이",98));
		list.add(new Student("개구리",5));
		
		Comparator<Student> c = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2.getScore(), o1.getScore());
			}
		};
		
		Collections.sort(list,c);
		System.out.println(list);
	}
}
