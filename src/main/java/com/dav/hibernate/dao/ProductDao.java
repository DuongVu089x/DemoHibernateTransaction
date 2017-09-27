package com.dav.hibernate.dao;

import java.util.List;

import com.dav.hibernate.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductDao.
 */
public interface ProductDao {

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
