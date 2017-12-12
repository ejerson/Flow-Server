package edu.cnm.deepdive.capstone.flashserver.controllers;

import edu.cnm.deepdive.capstone.flashserver.entities.Card;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cards", path = "cards")
public interface CardController extends PagingAndSortingRepository<Card, Long> {

  @Query(value = "SELECT * FROM Card c WHERE c.configuration_id IS NULL AND c.deck_id = :deckId AND review_status = 'review pool member'", nativeQuery = true)
  List<Card> findAvailableByDeck(@Param("deckId") long deckId);

}

