package edu.cnm.deepdive.capstone.flashserver.entities;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Deck {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String deckName;
  private int reviewPool;
  private String deckIcon;
  private Date created;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToOne(mappedBy = "deck")
  private Configuration configuration;



  public long getId() {
    return id;
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

  public void setCreated(Date created) {
    this.created = created;
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