package com.sgic.internal.defecttracker.dashBoard.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="defectservices",   name="defectcount")
public class SeverityCount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="defect_countid")
	private Long defectCountId;
	
	@Column(name="total_defect")
	private Long totaldefect;
	
	@Column(name="medium_count")
	private Long mediumCount;
	
	@Column(name="low_count")
	private Long lowCount;
	
	@Column(name="high_count")
	private Long highCount;
	
	public Long getDefectCountId() {
		return defectCountId;
	}
	public void setDefectCountId(Long defectCountId) {
		this.defectCountId = defectCountId;
	}
	public Long getTotaldefect() {
		return totaldefect;
	}
	public void setTotaldefect(Long totaldefect) {
		this.totaldefect = totaldefect;
	}
	public Long getMediumCount() {
		return mediumCount;
	}
	public void setMediumCount(Long mediumCount) {
		this.mediumCount = mediumCount;
	}
	public Long getLowCount() {
		return lowCount;
	}
	public void setLowCount(Long lowCount) {
		this.lowCount = lowCount;
	}
	public Long getHighCount() {
		return highCount;
	}
	public void setHighCount(Long highCount) {
		this.highCount = highCount;
	}

		
}
