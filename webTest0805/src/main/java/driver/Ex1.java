package driver;

import member.MemberDAO;
import member.MemberDTO;

public class Ex1 {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getOne("admin", "1234");
		System.out.println(dto);
		
	}
}
