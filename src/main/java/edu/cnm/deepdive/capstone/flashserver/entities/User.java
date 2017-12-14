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

/**
 * Used for the users information
 */

@Entity(name = "Flowwer")
public class User {

  /**
   * Annotation to generate automated unique key id for use in entity.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  /**
   * Saves email address.
   */
  @Column(nullable = false)
  private String emailAddress;

  /**
   * Saves user name.
   */
  @Column(nullable = false)
  private String userName;

  /**
   * Generate timestamp to be used with id to reference records in the entity.
   */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  /**
   * Map one user to many achievements.
   */
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private List<Achievement> achievements = new LinkedList<>();

  /**
   * Map one user to many decks.
   */
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private List<Deck> decks = new LinkedList<>();

  /**
   * Provides access to generated id.
   */
  public long getId() {
    return id;
  }

  /**
   * Provides access to user email address.
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * Allows addition of current email address.
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * Provides access to users name.
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Allows addition of users name.
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Provides access to deck list.
   */
  public List<Deck> getDecks() {
    return decks;
  }

  /**
   * Allows addition of decks list.
   */
  public void setDecks(List<Deck> decks) {
    this.decks = decks;
  }

  /**
   * Provides access to created date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Provides access to list of achievments.
   */
  public List<Achievement> getAchievements() {
    return achievements;
  }

  /**
   * Allows access to current achievements.
   */
  public void setAchievements(
      List<Achievement> achievements) {
    this.achievements = achievements;
  }
}
