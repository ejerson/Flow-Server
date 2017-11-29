package edu.cnm.deepdive.capstone.flashserver.controllers;

import edu.cnm.deepdive.capstone.flashserver.entities.User;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserController extends PagingAndSortingRepository<User, Long> {

  List<User> findByLastName(@Param("lastname") String lastName);
}
