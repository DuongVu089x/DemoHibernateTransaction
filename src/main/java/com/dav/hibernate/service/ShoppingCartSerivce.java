package com.dav.hibernate.service;

import java.util.Collection;

import com.dav.hibernate.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Interface ShoppingCartSerivce.
 */
public interface ShoppingCartSerivce {

	/**
	 * Purchase.
	 *
	 * @param items the items
	 * @throws Exception the exception
	 */
	void purchase(Collection<Product> items) throws Exception;
}
