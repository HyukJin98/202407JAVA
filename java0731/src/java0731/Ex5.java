package java0731;

import java.util.Arrays;
import java.util.List;

public class Ex5 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동",Member.MALE,150),
				new Member("이혓진",Member.MALE,27),
				new Member("기모찌",Member.FEMALE,32),
				new Member("홍삼동",Member.MALE,67),
				new Member("김옥지",Member.FEMALE,35),
				new Member("응가",Member.MALE,200)
				);
		//전체 평균 나이
		double avg = list.stream().mapToInt(a->a.getAge()).average().orElse(0);
		System.out.println(avg);
		//남자 평균 나이
		double avgM = list.stream().filter(x->x.getSex() == Member.MALE).mapToInt(a->a.getAge()).average().orElse(0);
		System.out.println(avgM);
	}
}
