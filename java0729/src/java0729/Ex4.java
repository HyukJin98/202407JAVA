package java0729;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ex4 {
	public static void main(String[] args) {
		Date date = new Date(); // 스레드 사용시 비추천
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd"); // 스레드 사용시 비추천
		String strNow = sdf.format(date);
		System.out.println(strNow);
		
		LocalDateTime now1 = LocalDateTime.now();
//		System.out.println(now1);
		String strNow1 = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(now1);
		System.out.println(strNow1);
		
	}
}
