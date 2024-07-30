package java0730;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Ken",100));
		list.add(new Student("Shin",60));
		list.add(new Student("Kim",80));
		
		long num = list.stream().filter(s -> s.getScore() >=70).count();
		System.out.println("70점 이상은 " + num + " 명");
		list.stream().filter(s->s.getScore() >= 70).forEach(s->System.out.println(s.getName())); // 스트림.중간작업.최종작업
//		for(int i = 0; i<list.size(); i++) {
//		if(list.get(i).getScore()<70) {
//			list.remove(i);
//		 }
//		}
		
		list.stream().forEach(a ->{
			System.out.println(a);
			String msg = MessageFormat.format("{0},  {1}",a.getName(),a.getScore() );
			System.out.println(msg);
		});
		
		
//		for(Student str : list) {
//			
//			System.out.println(str);
//			String msg = MessageFormat.format("{0},  {1}",str.getName(),str.getScore() );
//			System.out.println(msg);
//			
//		}
	}
}
	

