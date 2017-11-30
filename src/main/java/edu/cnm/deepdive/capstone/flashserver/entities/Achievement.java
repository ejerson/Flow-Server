package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Achievement {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

@OneToMany
  private List<Deck> trackDeck;

  private String deckName;
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
}
