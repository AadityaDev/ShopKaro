package com.aditya.webapp.helper;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.aditya.webapp.dto.ItemDto;
import com.aditya.webapp.dto.ShopDto;
import com.aditya.webapp.dto.UserDto;
import com.aditya.webapp.models.Item;
import com.aditya.webapp.models.Shop;
import com.aditya.webapp.models.User;

@Component
public class ItemHelper {

	public void fillItemDetail(@NotNull ItemDto itemDto,@NotNull long shopId,@NotNull Item item) {
		item.setAverageRating(itemDto.getAverageRating());
		item.setName(itemDto.getName());
		item.setPictureUrl(itemDto.getPictureUrl());
		item.setDescription(itemDto.getDescription());
		item.setSpecification(itemDto.getSpecification());
		item.setPictureUrl(itemDto.getPictureUrl());
		item.setPrice(itemDto.getPrice());
		item.setDiscount(itemDto.getDiscount());
		item.setDiscountAvailable(itemDto.isDiscountAvailable());
		item.setCategory(itemDto.getCategory());
		item.setSpecification(itemDto.getSpecification());
		item.setItemsInStock(itemDto.getItemsInStock());
		item.setEMIAvailable(itemDto.isEMIAvailable());
		Calendar currentDate = Calendar.getInstance();
		Calendar expiryDate = Calendar.getInstance();
		item.setCreatedDate(currentDate.getTime());
		item.setUpdatedDate(expiryDate.getTime());
		item.setShopId(shopId);
	}

}
