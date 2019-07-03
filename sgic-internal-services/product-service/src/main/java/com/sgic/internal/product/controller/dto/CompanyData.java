package com.sgic.internal.product.controller.dto;

import java.sql.Date;

public class CompanyData {
	private Long companyId; // Id AUTO INCREMENT
	private String companyName; // Company Name
	private String companyAbbrivation; // Company Short Name
	private String companyRegNo; // Company Registration No
	private String companyAdminName; // Company Admin Name
	private String companyAdminEmail; // Company admin Email
	
	private Long companyLicenseTypeId; // Company License Type ID from CompanyLicenseType Entity
	private String companyLicenseTypeName; //  Company License Type Name from CompanyLicenseType Entity
	
	private int companyLicensePeriod; // Duration of the license Period
	private Date licenseStartDate; // License Start Date
	private Date licenseEndDate; // License End Date
	private String companyDescription; // Description about the Company



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




	public Long getCompanyLicenseTypeId() {
		return companyLicenseTypeId;
	}

	public void setCompanyLicenseTypeId(Long companyLicenseTypeId) {
		this.companyLicenseTypeId = companyLicenseTypeId;
	}

	public String getCompanyLicenseTypeName() {
		return companyLicenseTypeName;
	}

	public void setCompanyLicenseTypeName(String companyLicenseTypeName) {
		this.companyLicenseTypeName = companyLicenseTypeName;
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
