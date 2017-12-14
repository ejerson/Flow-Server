package edu.cnm.deepdive.capstone.flashserver.controllers;


import edu.cnm.deepdive.capstone.flashserver.entities.Configuration;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Allows for the setting of configuration URL path.
 */

@RepositoryRestResource(collectionResourceRel = "configurations", path = "configurations")
interface ConfigurationController
    extends PagingAndSortingRepository<Configuration, Long> {

  // TODO assign cards for a new configuration
}
