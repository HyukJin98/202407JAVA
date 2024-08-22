package du.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
public class BoardDto {
    public BoardDto() {
		// TODO Auto-generated constructor stub
	}
	private int num;
    private String writer;
    private String title;
    private String content;
    private String regtime;
    private int hits;
    
}