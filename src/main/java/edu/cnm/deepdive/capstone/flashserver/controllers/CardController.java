package edu.cnm.deepdive.capstone.flashserver.controllers;

import edu.cnm.deepdive.capstone.flashserver.entities.Card;
import edu.cnm.deepdive.capstone.flashserver.entities.Deck;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cards", path = "cards")
public interface CardController extends PagingAndSortingRepository<Card, Long> {

  List<Card> findByFront(@Param("front") String front);
}

