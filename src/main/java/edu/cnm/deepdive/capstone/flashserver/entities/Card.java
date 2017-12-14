package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Used for card creation for the deck.
 */
@Entity
public class Card {

  /**
   * Annotation to generate automated unique key id for use in entity.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * Generate timestamp to be used with id to reference records in the entity.
   */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  /**
   * Join many cards to one deck.
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "deck_id")
  private Deck deck;

  /**
   * Join many cards to one configuration
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "configuration_id")
  private Configuration configuration;

  /**
   * Saves achievement level.
   */
  private int level;

  /**
   * Saves front of card.
   */
  private String front;

  /**
   * Saves back of card.
   */
  private String back;

  /**
   * Saves image one.
   */
  private String imageOne;

  /**
   * Saves image two.
   */
  private String imageTwo;

  /**
   * Saves image three.
   */
  private String imageThree;

  /**
   * Saves image four.
   */
  private String imageFour;

  /**
   * Saves status review.
   */
  private String reviewStatus;

  /**
   * Provides access to the card id.
   */
  public long getId() {
    return id;
  }

  /**
   * Provides access to the front of card.
   */
  public String getFront() {
    return front;
  }

  /**
   * Allows addition of front of card.
   */
  public void setFront(String front) {
    this.front = front;
  }

  /**
   * Provides access to the back of card.
   */
  public String getBack() {
    return back;
  }

  /**
   * Allows addition to back of card.
   */
  public void setBack(String back) {
    this.back = back;
  }

  /**
   * Provides access to image one.
   */
  public String getImageOne() {
    return imageOne;
  }

  /**
   * Allows addition of image one.
   */
  public void setImageOne(String imageOne) {
    this.imageOne = imageOne;
  }

  /**
   * Provides access to image two.
   */
  public String getImageTwo() {
    return imageTwo;
  }

  /**
   * Allows addition of image two.
   */
  public void setImageTwo(String imageTwo) {
    this.imageTwo = imageTwo;
  }

  /**
   * Provides access to image three.
   */
  public String getImageThree() {
    return imageThree;
  }

  /**
   * Allows addition of image three.
   */
  public void setImageThree(String imageThree) {
    this.imageThree = imageThree;
  }

  /**
   * Provides access to image four.
   */
  public String getImageFour() {
    return imageFour;
  }

  /**
   * Allows addition of image four.
   */
  public void setImageFour(String imageFour) {
    this.imageFour = imageFour;
  }

  /**
   * Provides access to deck.
   */
  public Deck getDeck() {
    return deck;
  }

  /**
   * Allows addition deck.
   */
  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  /**
   * Provides access date created.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Provides access to user level.
   */
  public int getLevel() {
    return level;
  }

  /**
   * Allows addition of current user level.
   */
  public void setLevel(int level) {
    this.level = level;
  }

  /**
   * Provides access to review status.
   */
  public String getReviewStatus() {
    return reviewStatus;
  }

  /**
   * Allows addition of review status.
   */
  public void setReviewStatus(String reviewStatus) {
    this.reviewStatus = reviewStatus;
  }

  /**
   * Provides access to configuration.
   */
  public Configuration getConfiguration() {
    return configuration;
  }

  /**
   * Allows addition of current configuration.
   */
  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }
}
