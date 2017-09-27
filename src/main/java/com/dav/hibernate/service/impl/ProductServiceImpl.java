package com.dav.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dav.hibernate.dao.ProductDao;
import com.dav.hibernate.entity.Product;
import com.dav.hibernate.service.ProductSerivce;

@Service
public class ProductServiceImpl implements ProductSerivce{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public Product findById(Integer id) {
		return productDao.findById(id);
	}

}
