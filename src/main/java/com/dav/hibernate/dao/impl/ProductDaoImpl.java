package com.dav.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dav.hibernate.dao.ProductDao;
import com.dav.hibernate.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductDaoImpl.
 */
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	/** The factory. */
	@Autowired
	SessionFactory factory;

	/* (non-Javadoc)
	 * @see com.dav.hibernate.dao.ProductDao#getAll()
	 */
	@Override
	public List<Product> getAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.dav.hibernate.dao.ProductDao#findById(java.lang.Integer)
	 */
	@Override
	public Product findById(Integer id) {
		Session session = factory.openSession();
		return (Product) session.load(Product.class, id);
	}

}
