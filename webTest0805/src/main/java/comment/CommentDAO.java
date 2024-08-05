package comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class CommentDAO {

    public List<CommentDTO> getCommentsByBoardId(int boardId) {
        List<CommentDTO> commentList = new ArrayList<>();
        String query = "SELECT * FROM comments WHERE board_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, boardId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CommentDTO comment = new CommentDTO(
                    rs.getInt("id"),
                    rs.getInt("board_id"),
                    rs.getString("content"),
                    rs.getString("author"),
                    rs.getTimestamp("created_at")
                );
                commentList.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return commentList;
    }

    public void addComment(CommentDTO comment) {
        String query = "INSERT INTO comments (board_id, content, author) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, comment.getBoardId());
            pstmt.setString(2, comment.getContent());
            pstmt.setString(3, comment.getAuthor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    public void deleteComment(int id) {
        String query = "DELETE FROM comments WHERE id = ?";
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
