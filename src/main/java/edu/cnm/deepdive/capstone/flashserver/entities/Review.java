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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Provides the cards to review.
 */
@Entity
public class Review {

  /**
   * Annotation to generate automated unique key id for use in entity.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * Generate timestamp to be used with id to reference records in the entity.
   */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  /**
   * Join one configuration to one review.
   */
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "configuration_id")
  private Configuration configuration;

  /**  */
  @ManyToMany
  private List<Card> reviewPool = new ArrayList<>();

  /**
   * Provides access to the card id.
   */
  public long getId() {
    return id;
  }

  /**
   * Provides access date created.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Provides access to configuration.
   */
  public Configuration getConfiguration() {
    return configuration;
  }

  /**
   * Allows addition of current configuration.
   */
  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }

  /**
   * Provides access to review pool.
   */
  public List<Card> getReviewPool() {
    return reviewPool;
  }

  /**
   * Allows addition of current review pool.
   */
  public void setReviewPool(List<Card> reviewPool) {
    this.reviewPool = reviewPool;
  }
}
