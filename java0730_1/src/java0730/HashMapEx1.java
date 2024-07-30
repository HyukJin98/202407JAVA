package java0730;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("신용권", 85);
		map.put("신용권", 95);
		map.put("신용권", 90);
		map.put("홍길덩", 90);
		System.out.println(map.size());
		System.out.println(map.get("신용권"));
		System.out.println(map.get("홍길덩"));
		
		Set<String> kk = map.keySet();
		for(String str : kk) {
			System.out.println(str);
			System.out.println(map.get(str));
		}
		
		Set<Map.Entry<String, Integer>> ee = map.entrySet();
		for(Map.Entry<String, Integer> kv : ee) {
			String k = kv.getKey();
			Integer v = kv.getValue();
			String msg = MessageFormat.format("키 ={0}, 값 = {1}",k,v);
			System.out.println(msg);
		}
	}
}
