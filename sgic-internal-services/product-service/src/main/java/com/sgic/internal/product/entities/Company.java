package com.sgic.internal.product.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(schema = "productservice", name = "company")
public class Company implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Id AUTO INCREMENT
	@NotEmpty
	@Size(min=2, max=50)
	private String name; // Company Name
	@NotEmpty
	@Size(min=2, max=20)
	private String abbrivation; // Company Short Name
	@NotEmpty
	@Size(min=2, max=20)
	private String regNo; // Company Registration No
	@NotEmpty
	@Size(min=2, max=25)
	private String companyAdminName; // Company Admin Name
	@NotEmpty
	@Pattern(regexp = "^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$")
	@Size(min=5, max=35)
	@Email(message = "Email should be valid and unique")
	@Column(unique=true)
	@Size(min=2, max=50)
	private String adminEmail; // Company admin Email
	@NotEmpty
	@Size(min=2, max=20)
	private String licenseType; // Free, Silver, Gold, Platinum
	@NotNull
	@Min(value = 1)
	@Max(value = 120)
	private int licensePeriod; // Duration of the license Period
	@NotNull
	private Date startDate; // License Start Date
	@NotNull
	private Date endDate; // License End Date
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


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
