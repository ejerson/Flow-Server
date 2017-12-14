package edu.cnm.deepdive.capstone.flashserver.controllers;

import edu.cnm.deepdive.capstone.flashserver.entities.Session;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Allows for the setting of sessions URL path.
 */

@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
public interface SessionController extends PagingAndSortingRepository<Session, Long> {
}
