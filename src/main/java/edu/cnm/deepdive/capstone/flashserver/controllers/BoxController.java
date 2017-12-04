package edu.cnm.deepdive.capstone.flashserver.controllers;


import edu.cnm.deepdive.capstone.flashserver.entities.Box;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "boxes", path = "boxes")
public interface BoxController extends PagingAndSortingRepository<Box, Long> {

}
