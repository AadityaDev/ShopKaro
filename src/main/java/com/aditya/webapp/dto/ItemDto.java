package com.aditya.webapp.dto;

import java.io.Serializable;
import java.util.List;

import com.aditya.webapp.constants.Category;

public class ItemDto implements Serializable {

	private long id;
	private String name;
	private String description;
	private String specification;
	private double price;
	private List<ReviewDto> reviews;
	private boolean isDiscountAvailable;
	private int discount;
	private long itemsInStock;
	private double averageRating;
	private boolean isEMIAvailable;
	private String category;
	private String pictureUrl;

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

	public String getSpecification(){
		return specification;
	}
	
	public void setSpecification(String specification){
		this.specification=specification;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<ReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDto> reviews) {
		this.reviews = reviews;
	}

	public boolean isDiscountAvailable() {
		return isDiscountAvailable;
	}

	public void setDiscountAvailable(boolean isDiscountAvailable) {
		this.isDiscountAvailable = isDiscountAvailable;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public long getItemsInStock() {
		return itemsInStock;
	}

	public void setItemsInStock(long itemsInStock) {
		this.itemsInStock = itemsInStock;
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

}
