package com.dav.hibernate.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class Product.
 */
@Entity
@Table(name="Products")
public class Product implements Serializable {

	/** The id. */
	@Id
	@GeneratedValue
	Integer id;

	/** The name. */
	String name;

	/** The unit brief. */
	String unitBrief;

	/** The unit price. */
	Double unitPrice;

	/** The image. */
	String image;

	/** The product date. */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	Date productDate;

	/** The available. */
	Boolean available;

	/** The description. */
	String description;
	//Integer categoryId;
	/** The quantity. */
	//String supplierId;
	Integer quantity;

	/** The discount. */
	Double discount;

	/** The special. */
	Boolean special;

	/** The latest. */
	Boolean latest;

	/** The views. */
	Integer views = 0;

	/** The order details. */
	@OneToMany(mappedBy="product")
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the unit brief.
	 *
	 * @return the unit brief
	 */
	public String getUnitBrief() {
		return unitBrief;
	}

	/**
	 * Sets the unit brief.
	 *
	 * @param unitBrief the new unit brief
	 */
	public void setUnitBrief(String unitBrief) {
		this.unitBrief = unitBrief;
	}

	/**
	 * Gets the unit price.
	 *
	 * @return the unit price
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Sets the unit price.
	 *
	 * @param unitPrice the new unit price
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Gets the product date.
	 *
	 * @return the product date
	 */
	public Date getProductDate() {
		return productDate;
	}

	/**
	 * Sets the product date.
	 *
	 * @param productDate the new product date
	 */
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	/**
	 * Gets the available.
	 *
	 * @return the available
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * Sets the available.
	 *
	 * @param available the new available
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
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
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * Sets the discount.
	 *
	 * @param discount the new discount
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * Gets the special.
	 *
	 * @return the special
	 */
	public Boolean getSpecial() {
		return special;
	}

	/**
	 * Sets the special.
	 *
	 * @param special the new special
	 */
	public void setSpecial(Boolean special) {
		this.special = special;
	}

	/**
	 * Gets the latest.
	 *
	 * @return the latest
	 */
	public Boolean getLatest() {
		return latest;
	}

	/**
	 * Sets the latest.
	 *
	 * @param latest the new latest
	 */
	public void setLatest(Boolean latest) {
		this.latest = latest;
	}

	/**
	 * Gets the views.
	 *
	 * @return the views
	 */
	public Integer getViews() {
		return views;
	}

	/**
	 * Sets the views.
	 *
	 * @param views the new views
	 */
	public void setViews(Integer views) {
		this.views = views;
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
