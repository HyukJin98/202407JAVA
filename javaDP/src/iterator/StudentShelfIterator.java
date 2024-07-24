package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentShelfIterator implements Iterator<Student>{
	private StudentShelf studentShelf;
	private int index;
	
	public StudentShelfIterator(StudentShelf studentShelf) { //생성자
		this.studentShelf = studentShelf;
		this.index = 0;
	}
	
	@Override
	public boolean hasNext() { //다음 책이 있나요
		// TODO Auto-generated method stub
		if(index < studentShelf.getLength()) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public Student next() { //다음 책을 가져올 때
		// TODO Auto-generated method stub
		if(!hasNext()) {
			throw new NoSuchElementException(); //예외 발생
		}
		Student student = studentShelf.getStudentAt(index);
		index++;
		return student;
	}

}
