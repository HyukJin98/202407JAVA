package java0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx10 {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		String sql = "select * from dept";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("테이블 이름 입력 >>");
		String str = sc.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속 성공!!");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from " + str);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numOfCol = rsmd.getColumnCount();
			System.out.println(numOfCol);
			for (int i = 1; i <= numOfCol; i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}