package com.dav.hibernate.service;

import java.util.List;

import com.dav.hibernate.entity.Product;

public interface ProductSerivce {
	List<Product> getAll();

	Product findById(Integer id);
}
