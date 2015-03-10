package com.jc.web.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jc.web.demo.dao.UserDao;
import com.jc.web.demo.domain.User;

/**
 * 带事务的service,被注解Transactional这个标识的类的方法都是一个完整的事务
 * @author JevonCode
 *
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		userDao.insert(user);;
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
