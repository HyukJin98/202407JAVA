package project1;
import java.util.Scanner;
public class Bank_2 {
	public static void main(String[] args) {
		Member member = null;
		boolean run = true;
		Scanner sc = new Scanner(System.in);

		
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3. 예금/출금 | 4.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택> ");
			Member member3 = new Member(0,0,0,0);
			member3.d = sc.nextInt();
			if(member3.d <= 0 || member3.d > 4) {
				System.out.println("1~4까지의 숫자를 입력하십시오");
			}

			switch(member3.d) {
			
			case 1: 
				System.out.println("로그인 처리 ");
				System.out.print("아이디 :");
				String name = sc.nextLine();
				System.out.print("패스워드 :");
				String pass = sc.nextLine();
				if(name.equals(member.name)) {
					if(pass.equals(member.num)) {
						System.out.println("로그인 성공");
					}
					else {
						System.out.println("비밀번호가 틀립니다.");
					}
				}
				else {
					System.out.println("존재하지 않는 아이디입니다.");
				}
				break;
			case 2:
				System.out.println("회원 가입");
				System.out.println("[필수 정보 입력]");
				System.out.print("이름 : ");
				String name2 = sc.nextLine();
				System.out.print("주민번호 앞 6자리 : ");
				String mynum = sc.nextLine();
				System.out.print("전화번호 : ");
				String phone = sc.nextLine();
				member = new Member(name2,mynum,phone);
				System.out.println(member);
				break;
			case 3:
				// 예금 출금
				System.out.println("예금 출금");
				boolean run2 = true;
			    Member member2 = new Member(0,0,0,0);
			   
				while (run2) {
					System.out.println("-------------------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("-------------------------------------");
					System.out.print("선택> ");
					member2.d = sc.nextInt();
					if(member2.d <= 0 || member2.d > 4) {
						System.out.println("1~4까지의 숫자를 입력하십시오");
					}
					switch (member2.d) {
					case 1:
						System.out.print("예금액> ");
						member2.p = sc.nextInt();
						member2.balance += member2.p;
						break;
					case 2:
						System.out.print("출금액> ");
						member2.m = sc.nextInt();
						member2.balance -= member2.m;
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(member2.balance);
						break;
					case 4:
						run2 = false;
						break;
					}
					System.out.println();
				}
				System.out.println("프로그램 종료");
				break;
			case 4:
				run = false;
				break;
			}
			System.out.println();
		}
		System.out.println("프로그램 전체 종료");
	}

}
