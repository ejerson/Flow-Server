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


@Entity
public class Configuration {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "deck_id")
  public Deck deck;

  @OneToOne(mappedBy = "configuration")
  private Achievement achievement;

  @OneToMany(mappedBy = "configuration", cascade= CascadeType.ALL)
  private List<Card> cards = new LinkedList<>();

//  private String reviewStatus;

  private String selectedDeckName;

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

  public String getSelectedDeckName() {
    return selectedDeckName;
  }

  public void setSelectedDeckName(String selectedDeckName) {
    this.selectedDeckName = selectedDeckName;
  }

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

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

