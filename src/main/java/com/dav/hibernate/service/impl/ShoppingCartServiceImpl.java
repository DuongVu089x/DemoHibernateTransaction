package com.dav.hibernate.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dav.hibernate.dao.ShopppingCartDao;
import com.dav.hibernate.entity.Product;
import com.dav.hibernate.service.ShoppingCartSerivce;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartServiceImpl.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartSerivce {

	/** The shoppping cart dao. */
	@Autowired
	ShopppingCartDao shopppingCartDao;

	/* (non-Javadoc)
	 * @see com.dav.hibernate.service.ShoppingCartSerivce#purchase(java.util.Collection)
	 */
	@Override
	public void purchase(Collection<Product> items) throws Exception {
		shopppingCartDao.purchase(items);
	}

}
