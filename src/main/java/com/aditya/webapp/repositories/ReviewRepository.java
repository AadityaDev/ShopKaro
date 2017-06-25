package com.aditya.webapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aditya.webapp.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

//	public List<Review> findUserReviews(@Param("customer_id") long customerId);

}
