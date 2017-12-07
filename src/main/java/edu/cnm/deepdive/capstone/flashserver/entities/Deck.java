package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Deck {

  @Id
  @TableGenerator(name = "deckid", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "deckid")
  @Column(name = "id")
  private long id;

  private String deckName;
  private int reviewPool;
  private String deckIcon;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToOne(mappedBy = "deck")
  private Configuration configuration;


  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  @OneToMany(mappedBy = "deck")
  private List<Card> cards = new LinkedList<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDeckName() {
    return deckName;
  }

  public void setDeckName(String deckName) {
    this.deckName = deckName;
  }

  public int getReviewPool() {
    return reviewPool;
  }

  public void setReviewPool(int reviewPool) {
    this.reviewPool = reviewPool;
  }

  public String getDeckIcon() {
    return deckIcon;
  }

  public void setDeckIcon(String deckIcon) {
    this.deckIcon = deckIcon;
  }

  public Date getCreated() {
    return created;
  }

  public Configuration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
