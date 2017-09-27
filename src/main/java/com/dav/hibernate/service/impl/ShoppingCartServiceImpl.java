package com.dav.hibernate.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dav.hibernate.dao.ShopppingCartDao;
import com.dav.hibernate.entity.Product;
import com.dav.hibernate.service.ShoppingCartSerivce;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartSerivce {
	
	@Autowired
	ShopppingCartDao shopppingCartDao;

	@Override
	public void purchase(Collection<Product> items) throws Exception {
		shopppingCartDao.purchase(items);
	}

}
