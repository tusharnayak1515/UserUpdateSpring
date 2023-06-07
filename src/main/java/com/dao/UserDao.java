package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.models.User;

@Component
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public User searchUserById(int id) {
		User user = new User();
		try {
			String query = "from User where id = ?0";
			List users = this.hibernateTemplate.find(query,new Object[] {id});
			if(users.isEmpty()) {
				user = null;
			}
			else {
				user = (User)users.get(0);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}
	
	@Transactional
	public void updateUser(User user) {
		try {
			this.hibernateTemplate.saveOrUpdate(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
