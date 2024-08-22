package com.board.service;

import java.util.ArrayList;
import java.util.List;

import com.board.db.BoardDao;
import com.board.db.BoardDto;
import com.board.db.Pagination;

public class BoardService {

    private static final int listSize = 2; 
    private static final int paginationSize = 2; 
    
    private BoardDao boardDao = new BoardDao();
	private int num;

    public List<BoardDto> getMsgList(int pageNo) {
        int start = (pageNo - 1) * listSize + 1;
        int end = pageNo * listSize;
        return boardDao.pageBoard(start, end);
    }

    public ArrayList<Pagination> getPagination(int pageNo) {

        ArrayList<Pagination> pgnList = new ArrayList<>();

        
        int numRecords = boardDao.countBoard2();
        int numPages = (int) Math.ceil((double) numRecords / listSize);

        int firstLink = ((pageNo - 1) / paginationSize) * paginationSize + 1;
        int lastLink = firstLink + paginationSize - 1;
        if (lastLink > numPages) {
            lastLink = numPages;
        }

        if (firstLink > 1) {
            pgnList.add(new Pagination("이전", pageNo - paginationSize, false));
        }

        for (int i = firstLink; i <= lastLink; i++) {
            pgnList.add(new Pagination("" + i, i, i == pageNo));
        }

        if (lastLink < numPages) {
            int tmpPageNo = pageNo + paginationSize;
            if (tmpPageNo > numPages) {
                tmpPageNo = numPages;
            }
            pgnList.add(new Pagination("다음", tmpPageNo, false));
        }

        return pgnList;
    }

    public BoardDto getMsg(int num) {
        BoardDto dto = boardDao.getBoardById(num);

        
        dto.setTitle(dto.getTitle().replace (" ",  "&nbsp;"));
        dto.setContent(dto.getContent().replace(" ",  "&nbsp;")
                                       .replace("\n", "<br>"));


        return dto;
    }

    public BoardDto getMsgForWrite(int num) {
        return boardDao.getBoardById(num);
    }

    public void writeMsg(String writer, String title, String content) throws Exception {

    	if (writer  == null || writer.length()  == 0 ||
                title   == null || title.length()   == 0 ||
                content == null || content.length() == 0) {

            throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        
        BoardDto dto = new BoardDto();
        dto.setWriter(writer);
        dto.setTitle  (title  );
        dto.setContent(content);

        boardDao.addBoard(dto);
    }

    public void updateMsg(String writer, String title, String content, int num) throws Exception {

    	 if (writer  == null || writer.length()  == 0 ||
    	            title   == null || title.length()   == 0 ||
    	            content == null || content.length() == 0) {
            throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        BoardDto dto = new BoardDto();
        dto.setNum    (num    );
        dto.setWriter (writer );
        dto.setTitle  (title  );
        dto.setContent(content);
        boardDao.updateBoard(dto);
    }

    public void deleteMsg(int num) {
        boardDao.deleteBoard(num);
    }

    
}
