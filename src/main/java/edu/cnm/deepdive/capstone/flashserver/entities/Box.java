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
public class Box {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Review> session;

  private int sessionNumber;

  @ManyToMany
  private List<Card> cardBox = new ArrayList<>();

  public long getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public List<Review> getSession() {
    return session;
  }

  public void setSession(List<Review> session) {
    this.session = session;
  }

  public int getSessionNumber() {
    return sessionNumber;
  }

  public void setSessionNumber(int sessionNumber) {
    this.sessionNumber = sessionNumber;
  }

  public List<Card> getCardBox() {
    return cardBox;
  }

  public void setCardBox(List<Card> cardBox) {
    this.cardBox = cardBox;
  }
}

