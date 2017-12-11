package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Configuration {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "deck_id")
  public Deck deck;

  @OneToOne(mappedBy = "configuration")
  private Achievement achievement;

//  private String reviewStatus;

  private int selectedDeck;

  private int session;

  private int duration;

  private int review_pool;  //cards


  //private int cardLevel; //per Edge

  //private long timer;  //per Edge

  //private String deckIcon; //per Edge

  //private int counter; //per Edge

  //private int achievementCounter; //per Edge


  public long getId() {
    return id;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public Date getCreated() {
    return created;
  }

  public Deck getDeck() {
    return deck;
  }

  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  public int getSession() {
    return session;
  }

  public void setSession(int session) {
    this.session = session;
  }

  public int getReview_pool() {
    return review_pool;
  }

  public void setReview_pool(int review_pool) {
    this.review_pool = review_pool;
  }

  public int getSelectedDeck() {
    return selectedDeck;
  }

  public void setSelectedDeck(int selectedDeck) {
    this.selectedDeck = selectedDeck;
  }
}

