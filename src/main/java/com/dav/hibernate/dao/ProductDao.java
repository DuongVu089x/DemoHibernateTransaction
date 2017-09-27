package com.dav.hibernate.dao;

import java.util.List;

import com.dav.hibernate.entity.Product;

public interface ProductDao {
	List<Product> getAll();

	Product findById(Integer id);
}
