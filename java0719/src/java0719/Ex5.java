package java0719;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class Ex5 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String createString;
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"spring5","spring5");
			System.out.println("Mysql 접속 성공!");
			
			System.out.println("데이터를 입력하세요 : ");
			createString = sc.nextLine();
			
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println("테이블 삽입"+ num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
