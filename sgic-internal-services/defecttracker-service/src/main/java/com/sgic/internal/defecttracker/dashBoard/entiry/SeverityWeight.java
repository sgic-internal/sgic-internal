package com.sgic.internal.defecttracker.dashBoard.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "defectservices", name = "severityweight")
public class SeverityWeight {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "severity_weight_id")
  private Long severityWeightId;

  @Column(name = "high_weight")
  private Long highWeight;

  @Column(name = "medium_weight")
  private Long mediumWeight;

  @Column(name = "low_weight")
  private Long lowWeight;

  public Long getSeverityWeightId() {
    return severityWeightId;
  }

  public void setSeverityWeightId(Long severityWeightId) {
    this.severityWeightId = severityWeightId;
  }

  public Long getHighWeight() {
    return highWeight;
  }

  public void setHighWeight(Long highWeight) {
    this.highWeight = highWeight;
  }

  public Long getMediumWeight() {
    return mediumWeight;
  }

  public void setMediumWeight(Long mediumWeight) {
    this.mediumWeight = mediumWeight;
  }

  public Long getLowWeight() {
    return lowWeight;
  }

  public void setLowWeight(Long lowWeight) {
    this.lowWeight = lowWeight;
  }



}
