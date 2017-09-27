package com.dav.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dav.hibernate.dao.ProductDao;
import com.dav.hibernate.entity.Product;
import com.dav.hibernate.service.ProductSerivce;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductSerivce{

	/** The product dao. */
	@Autowired
	private ProductDao productDao;

	/* (non-Javadoc)
	 * @see com.dav.hibernate.service.ProductSerivce#getAll()
	 */
	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	/* (non-Javadoc)
	 * @see com.dav.hibernate.service.ProductSerivce#findById(java.lang.Integer)
	 */
	@Override
	public Product findById(Integer id) {
		return productDao.findById(id);
	}

}
