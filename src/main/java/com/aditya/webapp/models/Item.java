package com.aditya.webapp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

import com.aditya.webapp.constants.Category;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = 8328747627879497405L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "specification")
	private String specification;
	@Column(name = "price")
	private double price;
	@Column(name = "is_discount_available")
	private boolean isDiscountAvailable;
	@Column(name = "discount")
	private double discount;
	@Column(name = "average_rating")
	private double averageRating;
	@Column(name = "is_EMI_available")
	private boolean isEMIAvailable;
	@Column(name = "category")
	private String category;
	@Column(name = "picture_url")
	private String pictureUrl;
	@Column(name = "shop_id")
	private long shopId;
	@Column(name = "items_in_stock")
	private long itemsInStock;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "updated_date")
	private Date updatedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDiscountAvailable() {
		return isDiscountAvailable;
	}

	public void setDiscountAvailable(boolean isDiscountAvailable) {
		this.isDiscountAvailable = isDiscountAvailable;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public boolean isEMIAvailable() {
		return isEMIAvailable;
	}

	public void setEMIAvailable(boolean isEMIAvailable) {
		this.isEMIAvailable = isEMIAvailable;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public long getItemsInStock() {
		return itemsInStock;
	}

	public void setItemsInStock(long itemsInStock) {
		this.itemsInStock = itemsInStock;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
