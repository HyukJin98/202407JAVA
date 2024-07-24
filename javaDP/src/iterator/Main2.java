package iterator;

import java.util.Iterator;

public class Main2 {
	public static void main(String[] args) {
		StudentShelf studentShelf = new StudentShelf(2);
		studentShelf.appendStudent(new Student("이혁진","2470035",100));
		studentShelf.appendStudent(new Student("개똥이","2470036",10));
		
		Iterator<Student> it = studentShelf.iterator();
		System.out.printf("  %s    %s       %s\n","이름","학번","자바점수");
		for(Student student : studentShelf) {
			System.out.printf(" %s   %s   %f\n",student.getName(),student.getHakBun(),student.getJava());
		}
		
	}
}
