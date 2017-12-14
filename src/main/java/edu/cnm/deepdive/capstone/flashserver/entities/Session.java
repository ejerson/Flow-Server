package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Provides the time a user selects to review.
 */

@Entity
public class Session {

  /** Generate timestamp to be used with id to reference records in the entity. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * Generate timestamp to be used with id to reference records in the entity.
   */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  /** Stores the session number. */
  private int sessionNumber;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Box> sessionPool = new ArrayList<>();

  /**  Provides access to the session id. */
  public long getId() {
    return id;
  }

  /**  Provides access date created. */
  public Date getCreated() {
    return created;
  }

  /**  Provides access to session number. */
  public int getSessionNumber() {
    return sessionNumber;
  }
  /**  Allows addition of session number. */
  public void setSessionNumber(int sessionNumber) {
    this.sessionNumber = sessionNumber;
  }

  /**  Provides access to session pool. */
  public List<Box> getSessionPool() {
    return sessionPool;
  }

  /**  Allows addition of session pool . */
  public void setSessionPool(
      List<Box> sessionPool) {
    this.sessionPool = sessionPool;
  }
}
