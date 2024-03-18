package com.work;

import java.util.List;

import com.entity.Manager;

/**
 * 操作用户的接口
 */
public interface ManagerDao {
	Manager queryManager(String name, String password) throws Exception;
	boolean deleteManager(Integer id);
	List<Manager> queryListManagers();
}
