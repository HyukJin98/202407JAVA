package comment;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    private int id;
    private int boardId;
    private String content;
    private String author;
    private Date createdAt;

    // Constructors
    public CommentDTO() {}

    public CommentDTO(int id, int boardId, String content, String author, Date createdAt) {
        this.id = id;
        this.boardId = boardId;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}