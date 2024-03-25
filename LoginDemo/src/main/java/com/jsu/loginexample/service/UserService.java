package com.jsu.loginexample.service;

import com.jsu.loginexample.dao.UserDao;
import com.jsu.loginexample.dao.UserDaoImpl;
import com.jsu.loginexample.model.User;

public class UserService {
	public UserDao userDao = new UserDaoImpl();
	
	/**
	 * 查询用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean queryUser(User user) throws Exception {
		User result = userDao.queryUserByUserName(user.getUsername());
		if(result != null) {
			return false;
		}
		return true;
	}

	/**
     * 注册用户
     * @param user
     * @return
     * @throws Exception
     */
	public boolean registerUser(User user) {
		return userDao.insertUser(user);
	}

	/**
     * 注销用户信息
     * @param user
     * @return
     * @throws Exception
     * */
	public boolean destroyUser(String username) {
		return userDao.deleteUser(username);
	}

}
