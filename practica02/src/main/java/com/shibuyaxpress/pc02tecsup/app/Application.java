package com.shibuyaxpress.pc02tecsup.app;

import com.shibuyaxpress.pc02tecsup.bean.User;
import com.shibuyaxpress.pc02tecsup.dao.UserDAO;
import com.shibuyaxpress.pc02tecsup.dao.UserDAOImpl;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDAO dao = new UserDAOImpl();
		
		int id = -1;
		
		id = dao.create("Paul", "pacheco123","D");
		
		User user = dao.findById(id);
		
		System.out.println("Create .. " + user.getUsername());

		dao.update(id, "Frank", "carpio", "C");
		
		user = dao.findById(id);
		
		System.out.println("Update .. " + user.getUsername());
				
		/*dao.delete(id);

		emp = dao.findById(id);

		System.out.println("Delete .. " + emp);		
		*/
		
		for (User item : dao.findAll()) {
			
			System.out.println(item.getId()+"-"+item.getUsername()+"-"+item.getPassword()+"-"+item.getType());
			 
		};

	}
}
