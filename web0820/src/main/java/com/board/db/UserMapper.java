package com.board.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    UserDTO selectUserById(@Param("id") String id);

    @Insert("INSERT INTO users (id, password, name) VALUES (#{id}, #{password}, #{name})")
    void insertUser(UserDTO userDto);
}
