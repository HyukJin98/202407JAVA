package boards;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class BoardDAO {

    public List<BoardDTO> getAllBoards() {                // 리스트 사용해서 select 쿼리 작성하기
        List<BoardDTO> boardList = new ArrayList<>();
        String query = "SELECT * FROM boards";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDTO board = new BoardDTO(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("author"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
                boardList.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return boardList;
    }

    public BoardDTO getBoardById(int id) {                    // id 기준으로 검색하기
        BoardDTO board = null;
        String query = "SELECT * FROM boards WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                board = new BoardDTO(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("author"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return board;
    }

    public void insertBoard(BoardDTO board) {                                             //인서트 보드
        String query = "INSERT INTO boards (title, content, author) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getAuthor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }
 
    public void updateBoard(BoardDTO board) {               //수정 보드
        String query = "UPDATE boards SET title = ?, content = ?, author = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getAuthor());
            pstmt.setInt(4, board.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    public void deleteBoard(int id) {                     //삭제 보드
        String query = "DELETE FROM boards WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }
}