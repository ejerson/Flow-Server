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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Session {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  private int sessionNumber;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Box> sessionPool = new ArrayList<>();

  public long getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }


  public int getSessionNumber() {
    return sessionNumber;
  }

  public void setSessionNumber(int sessionNumber) {
    this.sessionNumber = sessionNumber;
  }

  public List<Box> getSessionPool() {
    return sessionPool;
  }

  public void setSessionPool(
      List<Box> sessionPool) {
    this.sessionPool = sessionPool;
  }
}
