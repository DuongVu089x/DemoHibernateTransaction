package com.dav.hibernate.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dav.hibernate.dto.ShoppingCartDto;
import com.dav.hibernate.service.ProductSerivce;
import com.dav.hibernate.service.ShoppingCartSerivce;

// TODO: Auto-generated Javadoc
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("home")
public class HomeController {

	/** The product serivce. */
	@Autowired
	ProductSerivce productSerivce;

	/** The shopping cart serivce. */
	@Autowired
	ShoppingCartSerivce shoppingCartSerivce;

	/** The cart dto. */
	@Autowired
	ShoppingCartDto cartDto;

	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("prods", productSerivce.getAll());
		model.addAttribute("message", "");
		return "home";
	}

	/**
	 * Purchase.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("purchase")
	public String purchase(ModelMap model) {
		try {
			shoppingCartSerivce.purchase(cartDto.getItems());
			cartDto.clear();
			model.addAttribute("message", "Purchase success");
		} catch (Exception e) {
			model.addAttribute("message", "Purchase not success");
			e.printStackTrace();
		}
		return "redirect:/home/index.htm";
	}
}
