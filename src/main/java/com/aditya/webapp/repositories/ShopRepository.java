package com.aditya.webapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aditya.webapp.models.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long>{

	@Query("select sh from Shop sh where sh.name=?1")
	public Shop findUserShop(String shopName);
	
	@Query("select sh from Shop sh where sh.customerId=?1")
	public Shop findUserShopById(long id);
}
