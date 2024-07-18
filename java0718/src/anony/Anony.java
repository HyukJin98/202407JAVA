package anony;

public class Anony {
	void method() {
		Person2 person2 = new Person2() {
			
			@Override
			public void wake() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Person person = new Person() {
 
			@Override
			void wake() {
				// TODO Auto-generated method stub
				super.wake();
			}
			
		};
	}

}
