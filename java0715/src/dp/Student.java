package dp;

import java.util.Vector;

public class Student {
	private Professor advisor;
	private String name;
	private Vector<Course> courses;
	
	
	public Student() {}
	public Student(String name) {
//		super();
		this.name = name;
		this.courses = new Vector<Course>();
	}
	
	@Override
	public String toString() {
		return "Student [advisor=" + advisor + ", name=" + name + ", courses=" + courses + "]";
	}
	
	public void registerCource(Course course) {
		courses.add(course);
	}
	
	public void dropCource(Course course) {
		if(courses.contains(course)) {
		courses.remove(course);
		}
	}
	
	public Professor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Professor advisor) {
		this.advisor = advisor;
	}

	public void advise(String msg) {
		System.out.println(msg);
	}
}
