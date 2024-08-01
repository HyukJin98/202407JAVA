package sec01.exam07;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReadEx {
	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("c://Temp/board1.csv");
		String line = "";
		BoardDAO dao = new BoardDAO();
		BufferedReader br = new BufferedReader(reader);
		while((line = br.readLine()) != null){
			//CSV 파일의 각 줄을 쉼표로 분리
			String[] data = line.split(",");
			BoardDTO dto = new BoardDTO(0,data[0] , data[1], data[2], "", 0);
			dao.insertBoard(dto);
			System.out.println("insert 완료");
//			분리된 데이터 출력
			for(String element : data) {
				System.out.println(element + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		//		while(true) {
//			int data = reader.read();
//			if(data == -1) break;
//			System.out.print((char)data);
//		}
		reader.close();
	}
}
