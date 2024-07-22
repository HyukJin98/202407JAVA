package java0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
//		String sql = "select * from dept where loc = '서울'";
		
		String sql1 = "select max(deptno) as max from dept";
		System.out.print("부서명 : ");
		String strName = sc.nextLine();
		System.out.print("부서 지역 : ");
		String strLoc = sc.nextLine();
		String sql = null;
//		String sql = String.format("select * from dept where loc = '%s'",str );
		System.out.println(sql);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속 성공!!");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			rs.next();
			int maxNo = rs.getInt(1);
			System.out.println(maxNo);
			sql = String.format("insert into dept(deptno,dname,loc) values ('%d', '%s', '%s')",maxNo+1,strName,strLoc);
			int res = stmt.executeUpdate(sql);
			System.out.println(res + "건을 입력 !");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}