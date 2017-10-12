package com.shibuyaxpress.pc02tecsup;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListaController {
private static final Logger logger = LoggerFactory.getLogger(ListaController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String lista(Locale locale, Model model) {
		logger.info("Mostrando datos de la tabla");
		
		return "lista";
	}
}
