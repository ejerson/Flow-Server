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

@Entity
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "configuration_id")
  private Configuration configuration;

  @ManyToMany
  private List<Card> reviewPool = new ArrayList<>();

  public long getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public Configuration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }

  public List<Card> getReviewPool() {
    return reviewPool;
  }

  public void setReviewPool(List<Card> reviewPool) {
    this.reviewPool = reviewPool;
  }
}
