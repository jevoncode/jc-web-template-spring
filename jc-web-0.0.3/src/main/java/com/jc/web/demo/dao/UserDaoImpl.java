package com.jc.web.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jc.web.demo.domain.User;

/**
 * JdbcTemplate 封装了jdbc,拥有事务功能,虽然没看到有事务相关的代码,但这是交给spring容器管理
 * @author JevonCode
 *
 */
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public void insert(User user) {
		String sql = "insert into tb_user(id,username) values(?,?)";
		jdbcTemplate.update(sql, user.getId(),user.getName());
	}
	
}
