package com.work;

import java.util.List;

import com.entity.Manager;

public class Main {
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
		ManagerDao managerDao = new ManagerDaoImpl();
//		1.查询单个用户
		Manager manager = managerDao.queryManager("zhao", "1");
		System.out.println("manager = " + manager);

//		2.查询所有用户
		List<Manager> resultList = managerDao.queryListManagers();
		System.out.println("all managers = " + resultList);
		
//		3.删除当个用户
		managerDao.deleteManager(2);
		resultList = managerDao.queryListManagers();
		System.out.println("all managers of size: " + resultList.size() + resultList);
    }
}
