package java0715;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayEx1 {
	public static void main(String[] args) {
		ArrayList<String> list;
		list = new ArrayList<String>();
		
/*		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
*/		
		list.add("홍길동");
		list.add("자바");
		list.add("Hello");
		
//      이터레이터 (자바 디자인 패턴)
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
		
/*		for(String str : list) {
			System.out.println(str);
		} */
	}

}
