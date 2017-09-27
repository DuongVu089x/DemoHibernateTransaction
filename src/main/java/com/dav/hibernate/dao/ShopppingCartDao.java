package com.dav.hibernate.dao;

import java.util.Collection;

import com.dav.hibernate.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Interface ShopppingCartDao.
 */
public interface ShopppingCartDao {

	/**
	 * Purchase.
	 *
	 * @param items the items
	 * @throws Exception the exception
	 */
	void purchase(Collection<Product> items) throws Exception;
}
