package edu.cnm.deepdive.capstone.flashserver;

import edu.cnm.deepdive.capstone.flashserver.entities.Achievement;
import edu.cnm.deepdive.capstone.flashserver.entities.Box;
import edu.cnm.deepdive.capstone.flashserver.entities.Card;
import edu.cnm.deepdive.capstone.flashserver.entities.Configuration;
import edu.cnm.deepdive.capstone.flashserver.entities.Deck;
import edu.cnm.deepdive.capstone.flashserver.entities.Review;
import edu.cnm.deepdive.capstone.flashserver.entities.Session;
import edu.cnm.deepdive.capstone.flashserver.entities.User;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * Exposes the Id MVC configuration.
 */

@Component
public class ExposeIdRestMVCConfiguration extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Achievement.class);
    config.exposeIdsFor(Box.class);
    config.exposeIdsFor(Card.class);
    config.exposeIdsFor(Configuration.class);
    config.exposeIdsFor(Deck.class);
    config.exposeIdsFor(Review.class);
    config.exposeIdsFor(Session.class);
    config.exposeIdsFor(User.class);

  }
}
