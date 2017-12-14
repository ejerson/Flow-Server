package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Provides deck activity.
 */
@Entity
public class Deck {

  /**
   * Annotation to generate automated unique key id for use in entity.
   */
  @Id
  @TableGenerator(name = "deckid", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "deckid")
  @Column(name = "id")
  private long id;

  /**
   * Used to track deck name.
   */
  private String deckName;

  /**
   * Used to track review pool.
   */
  private int reviewPool;

  /**
   * Used to track deck icon.
   */
  private String deckIcon;

  /**
   * Generate timestamp to be used with id to reference records in the entity.
   */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  /**
   * Join many decks to one user.
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

  /**
   * Join one deck to many configurations.
   */
  @OneToMany(mappedBy = "deck")
  private List<Configuration> configurations = new ArrayList<>();

  /**
   * Provides access to list of cards.
   */
  public List<Card> getCards() {
    return cards;
  }

  /**
   * Allows addition of card list .
   */
  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  /**
   * Provides one deck to many cards.
   */
  @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL)
  private List<Card> cards = new LinkedList<>();

  /**
   * Provides access to the deck id.
   */
  public long getId() {
    return id;
  }

  /**
   * Allows addition of current id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Provides access to deck name.
   */
  public String getDeckName() {
    return deckName;
  }

  /**
   * Allows addition current deck name.
   */
  public void setDeckName(String deckName) {
    this.deckName = deckName;
  }

  /**
   * Provides access to review pool.
   */
  public int getReviewPool() {
    return reviewPool;
  }

  /**
   * Allows addition of review pool.
   */
  public void setReviewPool(int reviewPool) {
    this.reviewPool = reviewPool;
  }

  /**
   * Provides access to deck icon.
   */
  public String getDeckIcon() {
    return deckIcon;
  }

  /**
   * Allows addition of current deck icon.
   */
  public void setDeckIcon(String deckIcon) {
    this.deckIcon = deckIcon;
  }

  /**
   * Provides access date created.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Provides access user.
   */
  public User getUser() {
    return user;
  }

  /**
   * Allows addition of current user.
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Provides access to selected configuration settings.
   */
  public List<Configuration> getConfigurations() {
    return configurations;
  }

  /**
   * Allows addition of selected configuration settings.
   */
  public void setConfigurations(
      List<Configuration> configurations) {
    this.configurations = configurations;
  }
}
