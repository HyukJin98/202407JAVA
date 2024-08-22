package com.board.service;

import com.board.db.UserDAO;
import com.board.db.UserDTO;

public class UserService {
	 private UserDAO userDao = new UserDAO();

	    public UserDTO login(String id, String password) throws Exception {
	        UserDTO user = userDao.getUserById(id);

	        if (user == null || !user.getPassword().equals(password)) {
	            throw new Exception("Invalid ID or Password");
	        }

	        return user;
	    }

	    public void register(UserDTO userDto) throws Exception {
	        // 중복된 ID가 있는지 확인
	        if (userDao.getUserById(userDto.getId()) != null) {
	            throw new Exception("User ID already exists");
	        }

	        // 필수 정보가 모두 입력되었는지 확인
	        if (userDto.getId() == null || userDto.getId().isEmpty() ||
	            userDto.getPassword() == null || userDto.getPassword().isEmpty() ||
	            userDto.getName() == null || userDto.getName().isEmpty()) {
	            throw new Exception("All fields must be filled");
	        }

	        // 사용자 등록
	        userDao.addUser(userDto);
	    }
}
