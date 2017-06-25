package com.aditya.webapp.controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import com.aditya.webapp.constants.Errors;
import com.aditya.webapp.dto.AppError;
import com.aditya.webapp.dto.AppResult;
import com.aditya.webapp.dto.IResult;
import com.aditya.webapp.dto.ShopDto;
import com.aditya.webapp.dto.UserDto;
import com.aditya.webapp.helper.UserHelper;
import com.aditya.webapp.models.Shop;
import com.aditya.webapp.models.User;
import com.aditya.webapp.repositories.ShopRepository;
import com.aditya.webapp.repositories.UserRepository;
import com.aditya.webapp.utilities.ExceptionUtils;
import com.aditya.webapp.utilities.StringUtils;

@RestController
public class UserServiceController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private UserHelper userHelper;
	static final Logger logger = LogManager.getLogger(UserServiceController.class.getSimpleName());

	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	@ResponseBody
	public IResult createUser(@RequestHeader(value="Accept",defaultValue="application/json") String accept,@RequestBody UserDto userDto) {

		AppResult datuxResult = new AppResult();
		User user = new User();
		userHelper.fillUserDetails(userDto, user);
		try {
			if (userRepository.findUserByEmail(userDto.getEmail()) != null) {
				datuxResult.setResult("User already exists");
			} else {
				userRepository.save(user);
				if (userDto.isOwner()) {
					Shop shop = new Shop();
					Shop oldShop=new Shop();
					userHelper.fillShopDetail(userDto, shop, user.getId());
					oldShop=shopRepository.findUserShop(shop.getName());
					if(oldShop==null){
						shopRepository.save(shop);
					}else{
						shop.setId(oldShop.getId());
						shopRepository.save(shop);
					}
				}
				datuxResult.setResult(userRepository.findUserByEmail(user.getEmail()));
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

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public IResult authenticateUser(@RequestHeader(value="Accept",defaultValue="application/json") String accept,@RequestBody UserDto userDto) {
		AppResult datuxResult = new AppResult();
		try {
			User user = userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
			if (user != null) {
				datuxResult.setResult(user);
			} else {
				datuxResult.setResult("Email Id or passord is incorrect!");
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

	@RequestMapping(value = "/user/details", method = RequestMethod.GET)
	@ResponseBody
	public IResult getUserDetails(@RequestHeader(value="Authorization") String authorization,@RequestHeader(value="Accept",defaultValue="application/json") String accept) {

		AppResult datuxResult = new AppResult();
		User user = new User();
		try {
			user = userRepository.findUserByAuthToken(authorization);
			datuxResult.setResult(user);
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

	@RequestMapping(value = "/user/details", method = RequestMethod.PUT)
	@ResponseBody
	public IResult updateUserDetails(@RequestHeader(value="Authorization") String authorization,@RequestHeader(value="Accept",defaultValue="application/json") String accept,@RequestBody UserDto userDto) {
		AppResult datuxResult = new AppResult();
		User user = new User();
		try {
			user = userRepository.findUserByAuthToken(authorization);
			if (user != null) {
				userHelper.fillUserDetails(userDto, user);
				userRepository.save(user);
				if (userDto.isOwner()) {
					Shop shop = new Shop();
					Shop oldShop=new Shop();
					userHelper.fillShopDetail(userDto, shop, user.getId());
					oldShop=shopRepository.findUserShop(shop.getName());
					if(oldShop==null){
						shopRepository.save(shop);
					}else{
						shop.setId(oldShop.getId());
						shopRepository.save(shop);
					}
				}
				datuxResult.setResult(user);
			} else {
				datuxResult.setResult("User not found!");
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

}
