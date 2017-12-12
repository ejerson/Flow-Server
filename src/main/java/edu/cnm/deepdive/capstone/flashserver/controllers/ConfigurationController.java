package edu.cnm.deepdive.capstone.flashserver.controllers;


import edu.cnm.deepdive.capstone.flashserver.entities.Configuration;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "configurations", path = "configurations")
interface ConfigurationController
    extends PagingAndSortingRepository<Configuration, Long> {

  List<Configuration> findBySelectedDeck(@Param("selecteddeck") int selectedDeck);

  // TODO assign cards for a new configuration
}
