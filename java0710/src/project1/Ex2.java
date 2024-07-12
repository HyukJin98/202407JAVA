package project1;

public class Ex2 {
	public static void main(String[] args) {
		Member mb = null;
		Member[] list = {
			new Member("강하나","911224","010-1234-5678"),
			new Member("김하나","891224","010-1234-3456"),
			new Member("이하나","901224","010-7890-5678")
		};
		for(Member member : list) {
			System.out.println(member);
		}
		int find = -1;
		for(int i =0;i<list.length;i++) {
			if(list[i].name.equals("김하나") && list[i].num.equals("891224")) {
				find = i;
				mb = list[i];
				break;
			}
		}
		System.out.println("인덱스 : "+find);
		System.out.println(mb);
		
		
		
	}
}
