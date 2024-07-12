package project1;

public class Member {
	String name;
	String num;  //주민번호 6자리 패스워드
	String pnum; // 핸드폰 번호
	int d;
	int balance;
	int p;
	int m;
	
	
	
	
	

	@Override
	public String toString() {
		return "Member [name=" + name + ", num=" + num + ", pnum=" + pnum + ", d=" + d + ", balance=" + balance + ", p="
				+ p + ", m=" + m + "]";
	}

	public Member(String name, String num, String pnum) {
		super();
		this.name = name;
		this.num = num;
		this.pnum = pnum;
	}
	
	public Member() {}
	
	
	public Member(int d,int p, int m,int balance) {
		super();
		this.d = d;
		this.p = p;
		this.m = m; 
		this.balance= balance;
	}
	

	
	
}
