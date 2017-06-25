package com.aditya.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.webapp.constants.Errors;
import com.aditya.webapp.dto.AppError;
import com.aditya.webapp.dto.AppResult;
import com.aditya.webapp.dto.IResult;
import com.aditya.webapp.dto.ItemDto;
import com.aditya.webapp.dto.UserDto;
import com.aditya.webapp.helper.ItemHelper;
import com.aditya.webapp.helper.UserHelper;
import com.aditya.webapp.models.Item;
import com.aditya.webapp.models.Shop;
import com.aditya.webapp.models.User;
import com.aditya.webapp.repositories.ItemRepository;
import com.aditya.webapp.repositories.ShopRepository;
import com.aditya.webapp.repositories.UserRepository;
import com.aditya.webapp.utilities.ExceptionUtils;
import com.aditya.webapp.utilities.StringUtils;

@RestController
public class ItemServiceController {

	@Autowired
	private Environment environment;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ItemHelper itemHelper;
	@Autowired
	private UserHelper userHelper;
	static final Logger logger = LogManager.getLogger(UserServiceController.class.getSimpleName());

	@RequestMapping(value = "/users/items/add", method = RequestMethod.POST)
	@ResponseBody
	public IResult addItem(@RequestHeader(value = "Authorization") String authToken,
			@RequestHeader(value = "Accept", defaultValue = "application/json") String accept,
			@RequestBody ItemDto itemDto) {
		User user = new User();
		AppResult datuxResult = new AppResult();
		Shop shop = new Shop();
		Long id = 1l;
		shop = shopRepository.findOne(id);
		Item item = new Item();
		try {
			user = userRepository.findUserByAuthToken(authToken);
			shop = shopRepository.findUserShopById(user.getId());
			itemHelper.fillItemDetail(itemDto, shop.getId(), item);
			itemRepository.save(item);
			datuxResult.setResult(itemRepository.findItemByName(item.getName()));
		} catch (Exception e) {
			ExceptionUtils.setException(e,
					new AppError(
							StringUtils.isNull(e.getMessage()) ? Errors.Exception.getDescription() : e.getMessage(),
							Errors.Exception.getCode()),
					datuxResult);
		} finally {
			return datuxResult;
		}
	}

	@RequestMapping(value = "/users/items/update", method = RequestMethod.PUT)
	@ResponseBody
	public IResult updateItem(@RequestHeader(value = "Authorization") String authToken,
			@RequestHeader(value = "Accept", defaultValue = "application/json") String accept,
			@RequestBody ItemDto itemDto) {
		User user = new User();
		AppResult datuxResult = new AppResult();
		Shop shop = new Shop();
		Item oldItem = new Item();
		try {
			shop = shopRepository.findUserShopById(user.getId());
			user = userRepository.findUserByAuthToken(authToken);
			oldItem = itemRepository.findItemByName(itemDto.getName());
			if (oldItem == null) {
				datuxResult.setResult("Item not exists!!");
			} else {
				itemHelper.fillItemDetail(itemDto, shop.getId(), oldItem);
				itemRepository.save(oldItem);
				datuxResult.setResult(oldItem);
			}
		} catch (Exception e) {
			ExceptionUtils.setException(e,
					new AppError(
							StringUtils.isNull(e.getMessage()) ? Errors.Exception.getDescription() : e.getMessage(),
							Errors.Exception.getCode()),
					datuxResult);
		} finally {
			return datuxResult;
		}
	}

	@RequestMapping(value = "/users/items/remove", method = RequestMethod.POST)
	@ResponseBody
	public IResult removeItem(@RequestHeader(value = "Authorization") String authToken,
			@RequestHeader(value = "Accept", defaultValue = "application/json") String accept,
			@RequestBody ItemDto itemDto) {
		User user = new User();
		AppResult datuxResult = new AppResult();
		Item oldItem = new Item();
		try {
			user = userRepository.findUserByAuthToken(authToken);
			oldItem = itemRepository.findUserItem(itemDto.getId());
			if (oldItem == null) {
				datuxResult.setResult("Item not exists!!");
			} else {
				itemRepository.delete(oldItem);
				datuxResult.setResult("Item Deleted succesfully!!");
			}
		} catch (Exception e) {
			ExceptionUtils.setException(e,
					new AppError(
							StringUtils.isNull(e.getMessage()) ? Errors.Exception.getDescription() : e.getMessage(),
							Errors.Exception.getCode()),
					datuxResult);
		} finally {
			return datuxResult;
		}
	}

	@RequestMapping(value = "/users/items", method = RequestMethod.GET)
	@ResponseBody
	public IResult getAllItems(@RequestHeader(value = "Authorization") String authToken,
			@RequestHeader(value = "Accept", defaultValue = "application/json") String accept) {
		User user = new User();
		AppResult datuxResult = new AppResult();
		List<Item> items = new ArrayList<Item>();
		Shop shop = new Shop();
		try {
			user = userRepository.findUserByAuthToken(authToken);
			shop = shopRepository.findUserShopById(user.getId());
			items.addAll(itemRepository.findUserItems(shop.getId()));
			datuxResult.setResult(items);
		} catch (Exception e) {
			ExceptionUtils.setException(e,
					new AppError(
							StringUtils.isNull(e.getMessage()) ? Errors.Exception.getDescription() : e.getMessage(),
							Errors.Exception.getCode()),
					datuxResult);
		} finally {
			return datuxResult;
		}
	}

}
