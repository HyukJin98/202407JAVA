package dp;

import java.util.Vector;

public class Course {
	private String id;
	private String name;
	private int unmOfStudents = 0;
	private Vector<Student> students;

	
	
	public void addStudent(Student student) {
		students.add(student);
		++unmOfStudents;
	}
	
	public void deleteStudent(Student student) {
		if(students.contains(student)) {
			students.remove(student);
			--unmOfStudents;
		}
	}


	
	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.students = new Vector<Student>();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void addStudent() {
		
	}
	public void deleteStudent() {
		
	}

	public Vector<Student> getStudents() {
		return students;
	}

	public int getUnmOfStudents() {
		return unmOfStudents;
	}
	
	

}
