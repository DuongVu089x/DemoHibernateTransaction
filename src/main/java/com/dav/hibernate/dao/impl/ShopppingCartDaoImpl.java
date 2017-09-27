package com.dav.hibernate.dao.impl;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dav.hibernate.dao.ShopppingCartDao;
import com.dav.hibernate.entity.Order;
import com.dav.hibernate.entity.OrderDetail;
import com.dav.hibernate.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Class ShopppingCartDaoImpl.
 */
@Repository
public class ShopppingCartDaoImpl implements ShopppingCartDao {

	/** The factory. */
	@Autowired
	SessionFactory factory;

	/* (non-Javadoc)
	 * @see com.dav.hibernate.dao.ShopppingCartDao#purchase(java.util.Collection)
	 */
	@Override
	public void purchase(Collection<Product> items) throws Exception {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Order order = new Order();
			order.setOrderDate(new Date());
			order.setRequireDate(new Date());
			// insert order
			session.save(order);

			// insert order detail
			for (Product p : items) {
				OrderDetail d = new OrderDetail();
				d.setProduct(p);
				d.setOrder(order);
				d.setUnitPrice(p.getUnitPrice());
				d.setQuantity(p.getQuantity());
				d.setDiscount(p.getDiscount());

				session.save(d);
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

}
