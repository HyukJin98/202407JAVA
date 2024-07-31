package drive;

import board.BoardDAO;
import board.BoardDTO;

public class Ex4 {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(2,"이혁진 글1","이혁진의 글","이혁진 글 내용","",0);
		dao.updateBoard(dto);
		System.out.println(dto);
	}
}
