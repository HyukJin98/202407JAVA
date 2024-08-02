package driver;

import board.BoardDAO;
import board.BoardDTO;

public class Ex1 {
	public static void main(String[] args) {
		BoardDTO dto = new BoardDTO(17, "기모찌", "의글", "의 내용", null, 0);
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(dto);
	}
}
