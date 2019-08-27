package com.example.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.model.Review;

@CrossOrigin(origins = {"*"})
@RepositoryRestResource(collectionResourceRel = "reviews", path = "reviews")
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

	List<Review> findByItemId(@Param(value = "itemId") Long itemid);

}
