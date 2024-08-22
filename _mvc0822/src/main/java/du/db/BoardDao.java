
package du.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDao {
    // SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
    SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
    SqlSession session;

    public BoardDao() {
        // SqlSessionFactory에서 session을 할당받는다.
        session = sqlsession_f.openSession(true);
    }

    public int getNumRecords() {
        return session.selectOne("BoardMapper.getNumRecords");
    }

    public List<BoardDto> selectList(int start, int listSize) {
        // session을 통해 쿼리를 실행하고 값을 받아온다.
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("listSize", listSize); // 수정된 부분
        return session.selectList("BoardMapper.selectList", map);
    }

    private void updateHits(int num) {
        session.update("BoardMapper.updateHits", num);
    }

    public BoardDto selectOne(int num, boolean hitsIncreased) {
        if (hitsIncreased) {
            updateHits(num);
        }
        return session.selectOne("BoardMapper.selectOne", num);
    }

    public int countBoard2() {
        BoardMapper bm = session.getMapper(BoardMapper.class);
        return bm.countBoard();
    }

    public void insertOne(BoardDto board) { // 수정된 부분: 매퍼와 일치하도록
        session.insert("BoardMapper.insertOne", board);
    }

    public void updateOne(BoardDto board) { // 수정된 부분: 매퍼와 일치하도록
        session.update("BoardMapper.updateOne", board);
    }

    public boolean deleteOne(int id) {
        try {
            session.update("BoardMapper.deleteBoard", id); // 수정된 부분
        } catch (Exception e) {
            System.out.println("여기!!!");
            return true;
        }
        return false;
    }

    public int countProducts(int id) {
        return session.selectOne("ProductMapper.countProducts", id);
    }
}

