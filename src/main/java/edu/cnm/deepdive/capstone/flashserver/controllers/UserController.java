package edu.cnm.deepdive.capstone.flashserver.controllers;

import edu.cnm.deepdive.capstone.flashserver.entities.User;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Allows for the setting of users URL path.
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserController extends PagingAndSortingRepository<User, Long> {

  List<User> findByUserName(@Param("username") String userName);

  List<User> findByEmailAddress(@Param("emailaddress") String emailAddress);

}




