package com.aditya.webapp.helper;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.aditya.webapp.dto.ShopDto;
import com.aditya.webapp.dto.UserDto;
import com.aditya.webapp.models.Shop;
import com.aditya.webapp.models.User;

@Component
public class UserHelper {

	public void fillUserDetails(@NotNull UserDto userDto,@NotNull User user){
		user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setSex(userDto.getSex());
        user.setAuthToken(userDto.getEmail()+"1234567");
        Calendar currentDate=Calendar.getInstance();
        Calendar expiryDate=Calendar.getInstance();
        expiryDate.add(Calendar.DAY_OF_MONTH, 7);
        user.setDate(currentDate.getTime());
        user.setUpdatedDate(currentDate.getTime());
        user.setCreatedDate(currentDate.getTime());
        user.setTokenExpiry(expiryDate.getTimeInMillis());
        user.setIs_owner(userDto.isOwner());
	}
	
	public void fillShopDetail(@NotNull UserDto userDto,@NotNull Shop shop,@NotNull long customerId){
		if((userDto.isOwner())&&(userDto.getShop()!=null)){
        	ShopDto shopDto=new ShopDto();
        	shopDto=userDto.getShop();
        	shop.setName(shopDto.getName());
        	shop.setAddress(shopDto.getAddress());
        	shop.setCity(shopDto.getCity());
        	shop.setCountry(shopDto.getCountry());
        	shop.setCustomerId(customerId);
        	Calendar currentDate=Calendar.getInstance();
            Calendar expiryDate=Calendar.getInstance();
        	shop.setCreatedDate(currentDate.getTime());
        	shop.setUpdatedDate(expiryDate.getTime());
        }
	}
	
}
