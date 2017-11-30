package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Flowwer")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String emailAddress;
  private String userName;
  private String timeStamp;

  @OneToMany(fetch = FetchType.EAGER)
  private List<Deck> deck;

// TODO - Add OneToMany to Deck
  public long getId() {
    return id;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public List<Deck> getDeck() {
    return deck;
  }

  public void setDeck(List<Deck> deck) {
    this.deck = deck;
  }
}
