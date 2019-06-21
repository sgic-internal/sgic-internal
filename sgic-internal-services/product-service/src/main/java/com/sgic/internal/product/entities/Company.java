package com.sgic.internal.product.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "productservice", name = "company")
public class Company implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Id AUTO INCREMENT
	private String name; // Company Name
	private String abbrivation; // Company Short Name
	private String regNo; // Company Registration No
	private String companyAdminName; // Company Admin Name
	private String adminEmail; // Company admin Email
	private String licenseType; // Free, Silver, Gold, Platinum
	private int licensePeriod; // Duration of the license Period
	private String startDate; // License Start Date
	private String endDate; // License End Date
	private String description; // Description about the Company

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrivation() {
		return abbrivation;
	}

	public void setAbbrivation(String abbrivation) {
		this.abbrivation = abbrivation;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getCompanyAdminName() {
		return companyAdminName;
	}

	public void setCompanyAdminName(String companyAdminName) {
		this.companyAdminName = companyAdminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public int getLicensePeriod() {
		return licensePeriod;
	}

	public void setLicensePeriod(int licensePeriod) {
		this.licensePeriod = licensePeriod;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
