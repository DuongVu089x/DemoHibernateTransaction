package com.dav.hibernate.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class Order.
 */
@Entity
@Table(name="Orders")
public class Order implements Serializable {

	/** The id. */
	@Id
	@GeneratedValue
	Integer id;

	/** The order date. */
	//String customerId;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	Date orderDate;

	/** The require date. */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	Date requireDate;

	/** The receiver. */
	String receiver;

	/** The address. */
	String address;

	/** The description. */
	String description;

	/** The amount. */
	Double amount;

	/** The order details. */
	@OneToMany(mappedBy="order")
	Collection<OrderDetail> orderDetails;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the order date.
	 *
	 * @return the order date
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the new order date
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets the require date.
	 *
	 * @return the require date
	 */
	public Date getRequireDate() {
		return requireDate;
	}

	/**
	 * Sets the require date.
	 *
	 * @param requireDate the new require date
	 */
	public void setRequireDate(Date requireDate) {
		this.requireDate = requireDate;
	}

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * Sets the receiver.
	 *
	 * @param receiver the new receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the order details.
	 *
	 * @return the order details
	 */
	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * Sets the order details.
	 *
	 * @param orderDetails the new order details
	 */
	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
