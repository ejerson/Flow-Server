package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Boxes are used to sort cards into groups according to how well the user knows each group.
 */
@Entity
public class Box {

  /** Annotation to generate automated unique key id for use in entity. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /** Generate timestamp to be used with id to reference records in the entity. */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  /**  Provides many to many link between box and sessions. */
  @ManyToMany(fetch = FetchType.EAGER)
  private List<Review> session;

  /**  Used to track sessions by number. */
  private int sessionNumber;

  /**  Provides many to many array of list of cards to boxes. */
  @ManyToMany
  private List<Card> cardBox = new ArrayList<>();

  /**  Provides access to the box id. */
  public long getId() {
    return id;
  }

  /**  Provides access to the created date. */
  public Date getCreated() {
    return created;
  }

  /**  Allows addition of selected session. */
  public List<Review> getSession() {
    return session;
  }

  /**  Allows addition of selected session. */
  public void setSession(List<Review> session) {
    this.session = session;
  }

  /** Provides access to Session number */
  public int getSessionNumber() {
    return sessionNumber;
  }

  /**  Allows addition of selected session number. */
  public void setSessionNumber(int sessionNumber) {
    this.sessionNumber = sessionNumber;
  }

  /**  Provides access to list of card boxes */
  public List<Card> getCardBox() {
    return cardBox;
  }

  /**  Allows addition of cards to boxes. */
  public void setCardBox(List<Card> cardBox) {
    this.cardBox = cardBox;
  }
}

