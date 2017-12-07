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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Flowwer")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(nullable = false)
  private String emailAddress;

  @Column(nullable = false)
  private String userName;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  //TODO: This should be one to one
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private List<Achievement> achievements = new LinkedList<>();

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private List<Deck> decks = new LinkedList<>();

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

  public List<Deck> getDecks() {
    return decks;
  }

  public void setDecks(List<Deck> decks) {
    this.decks = decks;
  }

  public Date getCreated() {
    return created;
  }

  public List<Achievement> getAchievements() {
    return achievements;
  }

  public void setAchievements(
      List<Achievement> achievements) {
    this.achievements = achievements;
  }
}
