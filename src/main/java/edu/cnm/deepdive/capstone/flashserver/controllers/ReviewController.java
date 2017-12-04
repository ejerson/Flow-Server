package edu.cnm.deepdive.capstone.flashserver.controllers;


import edu.cnm.deepdive.capstone.flashserver.entities.Review;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "reviews", path = "reviews")
public interface ReviewController extends PagingAndSortingRepository<Review, Long> {

}
