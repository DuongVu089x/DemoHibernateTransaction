package com.dav.hibernate.service;

import java.util.List;

import com.dav.hibernate.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductSerivce.
 */
public interface ProductSerivce {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	List<Product> getAll();

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the product
	 */
	Product findById(Integer id);
}
