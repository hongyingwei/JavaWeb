package com.work;

import java.util.List;

import com.entity.Manager;

public class Main {
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
		ManagerDao managerDao = new ManagerDaoImpl();
//		1.��ѯ�����û�
		Manager manager = managerDao.queryManager("zhao", "1");
		System.out.println("manager = " + manager);

//		2.��ѯ�����û�
		List<Manager> resultList = managerDao.queryListManagers();
		System.out.println("all managers = " + resultList);
		
//		3.ɾ�������û�
		managerDao.deleteManager(2);
		resultList = managerDao.queryListManagers();
		System.out.println("all managers of size: " + resultList.size() + resultList);
    }
}
