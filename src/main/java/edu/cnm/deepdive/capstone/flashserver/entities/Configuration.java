package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Configuration {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  public long duration;

  public long consecutiveDays;

  public long timer;

  private Date created;

  public String deckIcon;

  public int counter;

  public int achievementCounter;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "deck_id")
  public Deck deck;

  @OneToOne(mappedBy = "configuration")
  private Achievement achievement;

  public long getId() {
    return id;
  }

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

  public int getAchievementCounter () {
    return achievementCounter;
  }

  public void setAchievementCounter ( int achievementCounter){
    this.achievementCounter = achievementCounter;
  }

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Deck getDeck() {
    return deck;
  }

  public void setDeck(Deck deck) {
    this.deck = deck;
  }

}

