package edu.cnm.deepdive.capstone.flashserver.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Achievement {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Date created;



  private String trackAchievement;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "configuration_id")
  private Configuration configuration;




  public long getId() {
    return id;
  }

  public String getTrackAchievement() {
    return trackAchievement;
  }

  public void setTrackAchievement(String trackAchievement) {
    this.trackAchievement = trackAchievement;
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
}
