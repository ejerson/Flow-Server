package edu.cnm.deepdive.capstone.flashserver.controllers;

import edu.cnm.deepdive.capstone.flashserver.entities.Achievement;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "achievements" , path = "achievements")
public interface AchievementController extends PagingAndSortingRepository<Achievement,Long> {

  //TODO review/confirm Id settings
  List<Achievement> findByachievementId(@Param("achievementId") String achievementId);

}
