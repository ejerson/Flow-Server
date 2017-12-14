package edu.cnm.deepdive.capstone.flashserver.entities;

import edu.cnm.deepdive.capstone.flashserver.BeanUtil;
import edu.cnm.deepdive.capstone.flashserver.controllers.CardController;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Used to provide users with choices for deck, number of cards, number of sessions
 * and time duration.
 */
@Entity
public class Configuration {

  /** Annotation to generate automated unique key id for use in entity.*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /** Generate timestamp to be used with id to reference records in the entity. */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  /** Join many configurations to one deck*/
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "deck_id")
  public Deck deck;

  /**  Provides one to one link between configuration and achievement points. */
  @OneToOne(mappedBy = "configuration")
  private Achievement achievement;

  /** Provides one to many link between configuration and cards. */
  @OneToMany(mappedBy = "configuration", cascade= CascadeType.ALL)
  private List<Card> cards = new LinkedList<>();

//  private String reviewStatus;
  /** Saves deck name.  */
  private String selectedDeckName;

  /** Saves selected session. */
  private int session;

  /** Saves selected duration. */
  private int duration;

  /** Saves number of cards. */
  private int review_pool;

  //private int cardLevel; //per Edge

  //private long timer;  //per Edge

  //private String deckIcon; //per Edge

  //private int counter; //per Edge

  //private int achievementCounter; //per Edge

  /** Provides access to generated id. */
  public long getId() {
    return id;
  }

  /** Used to read number of days. */
  public int getDuration() {
    return duration;
  }

  /** Used to write out duration picked from spinner.*/
  public void setDuration(int duration) {
    this.duration = duration;
  }

  /** Used to read generated date for created record. */
  public Date getCreated() {
    return created;
  }

  /** Used to read which deck was selected.*/
  public Deck getDeck() {
    return deck;
  }

  /** Writes out current deck. */
  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  /** Used to read the number of sessions user picked.*/
  public int getSession() {
    return session;
  }

  /** Used to write the session number.*/
  public void setSession(int session) {
    this.session = session;
  }

  /** Provides access to the pool of cards.*/
  public int getReview_pool() {
    return review_pool;
  }

  /** Allows changes to review pool*/
  public void setReview_pool(int review_pool) {
    this.review_pool = review_pool;
  }

  /** Provides access to the deck name.*/
  public String getSelectedDeckName() {
    return selectedDeckName;
  }

  /** Allows addition of named deck.*/
  public void setSelectedDeckName(String selectedDeckName) {
    this.selectedDeckName = selectedDeckName;
  }

  /** Allow access to list of cards. */
  public List<Card> getCards() {
    return cards;
  }

  /** Allows addition of cards from list of cards. */
  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  /** Grab a list of cards and then save them to database.*/
  @PrePersist
  private void selectCards() {
    CardController cardController = BeanUtil.getBean(CardController.class);
    List<Card> available = cardController.findAvailableByDeck(getDeck().getId());
    Collections.shuffle(available);
    List<Card> assigned = available.stream().limit(getReview_pool()).map(c -> {
      c.setConfiguration(this);
      c.setReviewStatus("currently being reviewed");
      return c;
    }).collect(Collectors.toList());
    cardController.save(assigned);
  }

}

