package com.aditya.webapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aditya.webapp.models.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

	public Item findItemByName(@Param("name") String name);
	
	public List<Item> findItemsByName(@Param("name") String name);

	public List<Item> findItemsByCategory(@Param("category") String category);

	@Query("select i from Item i where i.shopId = ?1")
	public List<Item> findUserItems(@Param("shop_id") long shopId);

	@Query("select i from Item i where i.shopId = ?1")
	public Item findUserItem(@Param("shop_id") long shopId);
	
}
