package java0718;

public class Ex3 {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Role role = driver;
		
		role = new Worker();
		if (role instanceof Worker) {
			Worker worker = (Worker) role;
			
		} 
		else {
		  
		}
		Person person = new Person();
		person.setRole(new Driver());
		person.doIt();
		person.setRole(new Worker());
		person.doIt();
	}

}
