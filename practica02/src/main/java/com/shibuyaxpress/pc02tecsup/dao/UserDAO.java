package com.shibuyaxpress.pc02tecsup.dao;

import java.util.ArrayList;

import com.shibuyaxpress.pc02tecsup.bean.User;

public interface UserDAO {

ArrayList<User> findAll();
	
	User findById(int id);
	
	int create(String pUsername, String pPassword, String pType);
	
	void delete(int id);
	
	void update(int id, String pUsername, String pPassword, String pType);
}
