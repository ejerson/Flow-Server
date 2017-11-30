package edu.cnm.deepdive.capstone.flashserver.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Achievement {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;


  @OneToOne(mappedBy = "user")
  private User user;


  private Date created;

  private List<Deck> trackDeck;
  private String trackAchievement;




  public long getId() {
    return id;
  }

  public List<Deck> getTrackDeck() {
    return trackDeck;
  }

  public void setTrackDeck(List<Deck> trackDeck) {
    this.trackDeck = trackDeck;
  }

  public String getTrackAchievement() {
    return trackAchievement;
  }

  public void setTrackAchievement(String trackAchievement) {
    this.trackAchievement = trackAchievement;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getCreated() {
    return created;
  }
  
}
