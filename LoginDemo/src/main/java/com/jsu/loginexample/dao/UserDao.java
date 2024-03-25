package com.jsu.loginexample.dao;

import com.jsu.loginexample.model.User;

public interface UserDao {
	User queryUser(String name, String password) throws Exception;
	User queryUserByUserName(String name) throws Exception;
	boolean insertUser(User user);
	boolean deleteUser(String username);
}
