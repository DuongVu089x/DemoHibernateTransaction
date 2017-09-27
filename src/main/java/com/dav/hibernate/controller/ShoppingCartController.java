package com.dav.hibernate.controller;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dav.hibernate.dto.ShoppingCartDto;
import com.dav.hibernate.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
	

@Controller
@RequestMapping("cart")
public class ShoppingCartController {

	@Autowired
	ShoppingCartDto cart;

	@RequestMapping("index")
	public String index() {
		return "site/shopping-cart";
	}

	@ResponseBody
	@RequestMapping("add")
	public String add(@RequestParam("id") Integer id) {
		cart.add(id);

		try {
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("count", cart.getCount());
			info.put("amount", cart.getAmount());
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(info);

			return json;
		} catch (Exception e) {
			return "{}";
		}
	}

	@ResponseBody
	@RequestMapping("remove")
	public String remove(@RequestParam("id") Integer id) {
		cart.remove(id);

		try {
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("count", cart.getCount());
			info.put("amount", cart.getAmount());
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(info);

			return json;
		} catch (Exception e) {
			return "{}";
		}
	}

	@RequestMapping("clear")
	public String clear() {
		cart.clear();
		return "site/shopping-cart";
	}

	@RequestMapping("update")
	public String update(HttpServletRequest request) {
		for (Product p : cart.getItems()) {
			String id = p.getId().toString();
			String value = request.getParameter(id);
			Integer newQty = Integer.valueOf(value);
			cart.update(p.getId(), newQty);
		}
		return "site/shopping-cart";
	}
}
