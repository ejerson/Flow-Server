package edu.cnm.deepdive.capstone.flashserver.controllers;

import edu.cnm.deepdive.capstone.flashserver.entities.Deck;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "decks", path = "decks")
public interface DeckController extends PagingAndSortingRepository<Deck, Long> {

  List<Deck> findByDeckName(@Param("deckname") String deckName);
}

