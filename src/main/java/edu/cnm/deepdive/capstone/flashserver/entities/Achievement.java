package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Used to track user achievement points once a all cards have been graduated.
 */
@Entity
public class Achievement {

  // TODO - Needs link to consecutive days.
  /** Track number of achievment point*/
  private int achievementPoint;
  /**  achievement description*/
  private String achievementDescription;

  /** Annotation to generate automated unique key id for use in entity.*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;


  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

  /** Generate timestamp to be used with id to reference records in the entity. */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  // TODO - Link to consecutive days and achievement point.
  /** Generate timestamp to refer to when goal was achieved. */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date goalAchieved;


  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "configuration_id")
  private Configuration configuration;

  /** Used to read generated id. */
  public long getId() {
    return id;
  }
  /** Used to read generated date for created record. */
  public Date getCreated() {
    return created;
  }

  public Configuration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }

}
