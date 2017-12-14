package edu.cnm.deepdive.capstone.flashserver.controllers;

import edu.cnm.deepdive.capstone.flashserver.entities.Achievement;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Customized REST achievments endpoint.
 */
@RepositoryRestResource(collectionResourceRel = "achievements", path = "achievements")
public interface AchievementController extends PagingAndSortingRepository<Achievement, Long> {


}
