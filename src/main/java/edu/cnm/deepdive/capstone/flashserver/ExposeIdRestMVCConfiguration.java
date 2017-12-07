package edu.cnm.deepdive.capstone.flashserver;

import edu.cnm.deepdive.capstone.flashserver.entities.Card;
import edu.cnm.deepdive.capstone.flashserver.entities.Deck;
import edu.cnm.deepdive.capstone.flashserver.entities.User;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class ExposeIdRestMVCConfiguration extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Deck.class);
    config.exposeIdsFor(User.class);
    config.exposeIdsFor(Card.class);
  }
}
