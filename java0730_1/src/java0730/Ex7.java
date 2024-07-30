package java0730;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.sql.*;
public class Ex7 {
	public static void main(String[] args) {
		List<Score> list = new ArrayList<>();
		String sql = "select * from score";
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection(URL, "root", "mysql");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				list.add(new Score(num,name,kor,eng,math));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		int korSum = list.stream().mapToInt(s->s.getKor()).sum();
		System.out.println("국어 총점 : " +korSum);
		int engSum = list.stream().mapToInt(s->s.getEng()).sum();
		System.out.println("영어 총점 : " +engSum);
		int mathSum = list.stream().mapToInt(s->s.getMath()).sum();
		System.out.println("수학 총점 : " +mathSum);
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		OptionalDouble korAvg = list.stream().mapToDouble(s->s.getKor()).average();
		korAvg.ifPresent(avg-> System.out.println("국어 평균 : " + avg));
		OptionalDouble engAvg = list.stream().mapToDouble(s->s.getEng()).average();
		engAvg.ifPresent(avg-> System.out.println("영어 평균 : " + avg));
		OptionalDouble mathAvg = list.stream().mapToDouble(s->s.getMath()).average();
		mathAvg.ifPresent(avg-> System.out.println("수학 평균 : " + avg));
	}
}
