package com.board.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {
	@Select("select count(*) from board")
	int countBoard();

	@Select("SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM board ORDER BY num) a WHERE ROWNUM <= #{end}) WHERE rnum >= #{start}")
	List<BoardDto> selectBoardsWithPagination(@Param("start") int start, @Param("end") int end);

	@Select("SELECT * FROM board")
	List<BoardDto> selectAll();

	@Select("SELECT * FROM board WHERE num = #{num}")
	BoardDto selectById(int num);

	@Insert("INSERT INTO board (writer,title,content,regtime,hits) VALUES (#{writer}, #{title}, #{content},sysdate,#{hits})")
	void insertBoard(BoardDto boardDto);

	@Update("UPDATE board SET writer = #{writer}, title = #{title}, content = #{content}, regtime = sysdate WHERE num = #{num}")
	void updateBoard(BoardDto boardDto);

	@Delete("DELETE FROM board WHERE num = #{num}")
	void deleteBoard(int num);
}