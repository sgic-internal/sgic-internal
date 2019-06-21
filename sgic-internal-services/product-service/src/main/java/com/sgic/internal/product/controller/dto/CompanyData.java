package com.sgic.internal.product.controller.dto;

public class CompanyData {
	private Long companyId; // Id AUTO INCREMENT
	private String companyName; // Company Name
	private String companyAbbrivation; // Company Short Name
	private String companyRegNo; // Company Registration No
	private String companyAdminName; // Company Admin Name
	private String companyAdminEmail; // Company admin Email
	private String companyLicenseType; // Free, Silver, Gold, Platinum
	private int companyLicensePeriod; // Duration of the license Period
	private String LicenseStartDate; // License Start Date
	private String LicenseEndDate; // License End Date
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

	public String getLicenseStartDate() {
		return LicenseStartDate;
	}

	public void setLicenseStartDate(String licenseStartDate) {
		LicenseStartDate = licenseStartDate;
	}

	public String getLicenseEndDate() {
		return LicenseEndDate;
	}

	public void setLicenseEndDate(String licenseEndDate) {
		LicenseEndDate = licenseEndDate;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

}
