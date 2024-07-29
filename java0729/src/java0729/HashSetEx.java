package java0729;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		  Set a = new HashSet();
		 
		  a.add(7);
		  System.out.println(a);
		 
		  boolean c = a.add(5);
		  System.out.println(a);
		 
		  boolean b = a.add(5);
		  System.out.println(a);
		 
		  boolean remove = a.remove(5);
		  System.out.println(a);
		 
		  System.out.println(a.size());  
		 
		} 
}
