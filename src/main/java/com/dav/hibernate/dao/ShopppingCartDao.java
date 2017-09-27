package com.dav.hibernate.dao;

import java.util.Collection;

import org.hibernate.Session;

import com.dav.hibernate.entity.Product;

public interface ShopppingCartDao {
	void purchase(Collection<Product> items) throws Exception;
}
