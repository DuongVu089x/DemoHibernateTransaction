package com.dav.hibernate.service;

import java.util.Collection;

import com.dav.hibernate.entity.Product;

public interface ShoppingCartSerivce {

	void purchase(Collection<Product> items) throws Exception;
}
