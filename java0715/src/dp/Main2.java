package dp;

public class Main2 {
	public static void main(String[] args) {
		Student minsu = new Student("민수"); //학생 등록
		Student gilldong = new Student("길동"); //학생 등록
		Course java = new Course("cs100","자바"); // 코스 등록
		Course cplus = new Course("cs101","C/C++"); // 코스 등록
		minsu.registerCource(java);
		java.addStudent(minsu);
		minsu.registerCource(cplus);
		cplus.addStudent(minsu);
		

		
		gilldong.registerCource(java);
		java.addStudent(gilldong);
//		System.out.println(minsu);
//		System.out.println(gilldong);
		
		// 코스별 신청자 출력
		System.out.println("자바 수강 신청자:" + java.getUnmOfStudents()+ "명");
		for(Student student : java.getStudents()) {
			System.out.println(student);
		}
		System.out.println("c/c++ 수강 신청자:" + cplus.getUnmOfStudents()+ "명");
		for(Student student : cplus.getStudents()) {
			System.out.println(student);
		}
	}

}
