package java0724;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex2 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept values(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("Mysql 접속 성공!");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1008);
			pstmt.setString(2, "게임부");
			pstmt.setString(3, "부산바캉스");
			int ret = pstmt.executeUpdate();
			System.out.println(ret+" 건 insert 성공!!");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
}

