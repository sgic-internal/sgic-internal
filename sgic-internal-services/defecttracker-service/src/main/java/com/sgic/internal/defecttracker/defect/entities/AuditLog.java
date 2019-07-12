package com.sgic.internal.defecttracker.defect.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "auditlog")
public class AuditLog implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long auditId;
	private String user;
	private String fixDate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="defectId", nullable=false)
	private Defect defect;

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFixDate() {
		return fixDate;
	}

	public void setFixDate(String fixDate) {
		this.fixDate = fixDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Defect getDefect() {
		return defect;
	}

	public void setDefect(Defect defect) {
		this.defect = defect;
	}

}