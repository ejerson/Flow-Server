package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import org.springframework.data.annotation.Id;

@Entity

public class Configuration {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  private long id;

  public long deckId;

  public long duration;

  public long consecutiveDays;

  public long timer;

  private Date created;

  public String deckIcon;

  public int counter;

  public long getId() {
    return id;
  }

  public int achievementCounter;

  @OneToOne(mappedBy = "deck")
  public Deck deck;

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }

  public long getConsecutive_days() {
    return consecutiveDays;
  }

  public void setConsecutive_days(long consecutive_days) {
    this.consecutiveDays = consecutive_days;
  }

  public long getTimer() {
    return timer;
  }

  public void setTimer(long timer) {
    this.timer = timer;
  }

  public String getDeckIcon() {
    return deckIcon;
  }

  public void setDeckIcon(String deckIcon) {
    this.deckIcon = deckIcon;
  }

  public long getDeckId() {
    return deckId; }

  public int getAchievementCounter () {
    return achievementCounter;
  }

  public void setAchievementCounter ( int achievementCounter){
    this.achievementCounter = achievementCounter;
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

}

