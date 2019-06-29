package com.sgic.internal.product.controller.dto;

import java.sql.Date;

//DTO for Company Entity 
//Created By:Tyron,24.06.2019
public class CompanyData {
	
	//Id auto increment
	private Long companyId;
	private String companyName; 
	private String companyAbbrivation; 
	private String companyRegNo; 
	private String companyAdminName; 
	private String companyAdminEmail; 
	private String companyLicenseType;
	private int companyLicensePeriod; 
	private Date licenseStartDate; 
	private Date licenseEndDate; 
	private String companyDescription; 

	public CompanyData() {
		super();
	}

	public CompanyData(String companyName, String companyAbbrivation, String companyRegNo,
			String companyAdminName, String companyAdminEmail, String companyLicenseType, int companyLicensePeriod,
			Date licenseStartDate, Date licenseEndDate, String companyDescription)
	{
		super();
		this.companyName = companyName;
		this.companyAbbrivation = companyAbbrivation;
		this.companyRegNo = companyRegNo;
		this.companyAdminName = companyAdminName;
		this.companyAdminEmail = companyAdminEmail;
		this.companyLicenseType = companyLicenseType;
		this.companyLicensePeriod = companyLicensePeriod;
		this.licenseStartDate = licenseStartDate;
		this.licenseEndDate = licenseEndDate;
		this.companyDescription = companyDescription;
	}
	
	//Getter and Setter for DTO Attributes
	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAbbrivation() {
		return companyAbbrivation;
	}

	public void setCompanyAbbrivation(String companyAbbrivation) {
		this.companyAbbrivation = companyAbbrivation;
	}

	public String getCompanyRegNo() {
		return companyRegNo;
	}

	public void setCompanyRegNo(String companyRegNo) {
		this.companyRegNo = companyRegNo;
	}

	public String getCompanyAdminName() {
		return companyAdminName;
	}

	public void setCompanyAdminName(String companyAdminName) {
		this.companyAdminName = companyAdminName;
	}

	public String getCompanyAdminEmail() {
		return companyAdminEmail;
	}

	public void setCompanyAdminEmail(String companyAdminEmail) {
		this.companyAdminEmail = companyAdminEmail;
	}

	public String getCompanyLicenseType() {
		return companyLicenseType;
	}

	public void setCompanyLicenseType(String companyLicenseType) {
		this.companyLicenseType = companyLicenseType;
	}

	public int getCompanyLicensePeriod() {
		return companyLicensePeriod;
	}

	public void setCompanyLicensePeriod(int companyLicensePeriod) {
		this.companyLicensePeriod = companyLicensePeriod;
	}

	

	public Date getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public Date getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Date licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

}
