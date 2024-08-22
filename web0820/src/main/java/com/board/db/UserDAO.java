package com.board.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class UserDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
    SqlSession session;

    public UserDAO() {
        session = sqlsession_f.openSession(true);
    }

    public UserDTO getUserById(String id) {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        return userMapper.selectUserById(id);
    }

    public void addUser(UserDTO userDto) {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.insertUser(userDto);
    }
}
