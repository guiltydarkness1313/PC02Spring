package com.shibuyaxpress.pc02tecsup;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shibuyaxpress.pc02tecsup.bean.User;
import com.shibuyaxpress.pc02tecsup.dao.UserDAO;
import com.shibuyaxpress.pc02tecsup.dao.UserDAOImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	public void addUser(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		UserDAO dao = new UserDAOImpl();
		for (User item : dao.findAll()) {
			System.out.println(item.getId()+"-"+item.getUsername()+"-"+item.getPassword()+"-"+item.getType()); 
		};		
}
	
}
