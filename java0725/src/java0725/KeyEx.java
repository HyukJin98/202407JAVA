package java0725;

import java.util.HashMap;

public class KeyEx {
	public static void main(String[] args) {
		HashMap<Integer,String> hashMap = new HashMap<>();
		hashMap.put(1, "홍길동");
		String val = hashMap.get(1);
		System.out.println(val);
		
//		HashMap<Key,String> hashMap = new HashMap<Key,String>();
//		hashMap.put(new Key(1), "홍길동");
//		String val = hashMap.get(new Key(1));
//		System.out.println(val);
	}
}
