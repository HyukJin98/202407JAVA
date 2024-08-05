package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String MEMBER_HOME = "select * from member";
	private String MEMBER_LOGIN = "select * from member where id = ? and pw = ?";
	private String MEMBER_LOGIN2 = "select * from member where id = ?";
	private String MEMBER_REGISTER = "insert into member(id,pw,name) values(?,?,?)";
	private String MEMBER_UPDATE = "update member set pw = ? name = ? where id = ?";
	
	public void updateMember(MemberDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, dto.getPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	
	public void insertMember(MemberDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_REGISTER);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getPw());
			stmt.setString(3, dto.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt,conn);
		}
	}
	
	
	
	
	public MemberDTO getOne(String id, String pw) {
		MemberDTO dto = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_LOGIN);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(rs.getString("id"),rs.getString("pw"),rs.getString("name"));
			}
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return dto;
	}
	
	public MemberDTO getTwo(String id) {
		MemberDTO dto = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_LOGIN2);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(rs.getString("id"),rs.getString("pw"),rs.getString("name"));
			}
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return dto;
	}
	
	public List<MemberDTO> getBoardList(){
		List<MemberDTO> list = new ArrayList<>();
		
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_HOME);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(rs.getString("id"),rs.getString("pw"),rs.getString("name"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		
		return list;
	}
}
