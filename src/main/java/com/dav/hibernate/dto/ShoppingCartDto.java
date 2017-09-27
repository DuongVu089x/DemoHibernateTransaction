package com.dav.hibernate.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dav.hibernate.entity.Product;
import com.dav.hibernate.service.ProductSerivce;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartDto.
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component("cart")
@Transactional
public class ShoppingCartDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The factory. */
	@Autowired
	SessionFactory factory;

	/** The product serivce. */
	@Autowired
	ProductSerivce productSerivce;

	/** The map. */
	Map<Integer, Product> map = new HashMap<Integer, Product>();

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public Collection<Product> getItems() {
		return map.values();
	}

	/**
	 * Adds the.
	 *
	 * @param id the id
	 */
	public void add(Integer id) {
		Product p = map.get(id);
		if (p != null) {
			p.setQuantity(p.getQuantity() + 1);
		} else {
			Session session = factory.openSession();
			p = productSerivce.findById(id);
			p.setQuantity(1);
			map.put(id, p);
			session.close();
		}
	}

	/**
	 * Removes the.
	 *
	 * @param id the id
	 */
	public void remove(Integer id) {
		map.remove(id);
	}

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param newQuantity the new quantity
	 */
	public void update(Integer id, Integer newQuantity) {
		Product p = map.get(id);
		p.setQuantity(newQuantity);
	}

	/**
	 * Clear.
	 */
	public void clear() {
		map.clear();
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Integer getCount() {
		Integer count = 0;
		for (Product p : map.values()) {
			count += p.getQuantity();
		}
		return count;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount() {
		Double amount = 0.0;
		for (Product p : map.values()) {
			amount += p.getQuantity() * p.getUnitPrice() * (1 - p.getDiscount());
		}
		return amount;
	}
}
