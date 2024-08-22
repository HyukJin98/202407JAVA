package du.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class MemberDao {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
    SqlSession session;

    public MemberDao() {
        session = sqlsession_f.openSession(true);
    }
    
    public int isMember(MemberDto memberDto) {
    	MemberMapper mm = session.getMapper(MemberMapper.class);
    	return mm.isMember(memberDto);
    }
    
    public MemberDto findMember(MemberDto memberDto) {
    	MemberMapper mm = session.getMapper(MemberMapper.class);
    	return mm.findMember(memberDto);
    }
    
    public void insertOne(MemberDto memberDto) {
    	MemberMapper mm = session.getMapper(MemberMapper.class);
    	mm.insertOne(memberDto);
    }
    
    public MemberDto selectById(String email) {
    	MemberMapper mm = session.getMapper(MemberMapper.class);
    	return mm.selectMemberById(email);
    }
}
