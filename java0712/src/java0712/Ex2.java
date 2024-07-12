package java0712;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
public class Ex2 {
	public static void main(String[] args) {
		
		int lotto[] = new int[6];
		Random rd = new Random();
		Set<Integer> lottoSet = new HashSet<>(); // 중복을 허용하지 않는 Set 사용
		while(lottoSet.size() < 6) {
			int number = rd.nextInt(45)+1;
			lottoSet.add(number);
		}
		
//	    lottoSet.add(1);
//	    lottoSet.add(1);
//	    System.out.println(lottoSet.size());
		System.out.println(lottoSet);
	}

}
