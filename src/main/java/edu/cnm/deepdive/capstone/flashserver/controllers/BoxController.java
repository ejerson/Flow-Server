package edu.cnm.deepdive.capstone.flashserver.controllers;


import edu.cnm.deepdive.capstone.flashserver.entities.Box;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Customized REST boxes endpoint used to reference box.
 */
@RepositoryRestResource(collectionResourceRel = "boxes", path = "boxes")
public interface BoxController extends PagingAndSortingRepository<Box, Long> {

}
