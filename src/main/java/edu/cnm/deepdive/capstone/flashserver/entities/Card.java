package edu.cnm.deepdive.capstone.flashserver.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Card {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  private String front;
  private String back;
  private String imageOne;
  private String imageTwo;
  private String imageThree;
  private String imageFour;

  @ManyToOne
  private Deck deck;

  public long getId() {
    return id;
  }

  public String getFront() {
    return front;
  }

  public void setFront(String front) {
    this.front = front;
  }

  public String getBack() {
    return back;
  }

  public void setBack(String back) {
    this.back = back;
  }

  public String getImageOne() {
    return imageOne;
  }

  public void setImageOne(String imageOne) {
    this.imageOne = imageOne;
  }

  public String getImageTwo() {
    return imageTwo;
  }

  public void setImageTwo(String imageTwo) {
    this.imageTwo = imageTwo;
  }

  public String getImageThree() {
    return imageThree;
  }

  public void setImageThree(String imageThree) {
    this.imageThree = imageThree;
  }

  public String getImageFour() {
    return imageFour;
  }

  public void setImageFour(String imageFour) {
    this.imageFour = imageFour;
  }

  public Deck getDeck() {
    return deck;
  }

  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }
}
