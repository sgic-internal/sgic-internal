<<<<<<< HEAD
package com.sgic.internal.defecttracker.project.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="configuration",schema="defectservices")
public class Configuration {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long configId;
	private String configName;
	private String configValue;
	private String configIcon;
	private String configColor;
	
	
	public Long getConfigId() {
		return configId;
	}
	public void setConfigId(Long configId) {
		this.configId = configId;
	}
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public String getConfigIcon() {
		return configIcon;
	}
	public void setConfigIcon(String configIcon) {
		this.configIcon = configIcon;
	}
	public String getConfigColor() {
		return configColor;
	}
	public void setConfigColor(String configColor) {
		this.configColor = configColor;
	}
	// create relationship with project
	@ManyToOne
	@JoinColumn(name="projectId",nullable=false)
	
	private Configuration configuration;

	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	

	
		
				
			
	
}
=======
//package com.sgic.internal.defecttracker.project.entities;
//
//
//import javax.persistence.Entity;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import javax.persistence.Table;
//
//@Entity
//@Table(name="configuration",schema="defectservices")
//public class Configuration {
//	@Id
////	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long configId;
//	private String configName;
//	private String configValue;
//	private String configIcon;
//	private String configColor;
//	
//	
//	public Long getConfigId() {
//		return configId;
//	}
//	public void setConfigId(Long configId) {
//		this.configId = configId;
//	}
//	public String getConfigName() {
//		return configName;
//	}
//	public void setConfigName(String configName) {
//		this.configName = configName;
//	}
//	public String getConfigValue() {
//		return configValue;
//	}
//	public void setConfigValue(String configValue) {
//		this.configValue = configValue;
//	}
//	public String getConfigIcon() {
//		return configIcon;
//	}
//	public void setConfigIcon(String configIcon) {
//		this.configIcon = configIcon;
//	}
//	public String getConfigColor() {
//		return configColor;
//	}
//	public void setConfigColor(String configColor) {
//		this.configColor = configColor;
//	}
//	// create relationship with project
//	@ManyToOne
//	@JoinColumn(name="projectId",nullable=false)
//	
//	private Configuration configuration;
//
//	public Configuration getConfiguration() {
//		return configuration;
//	}
//	public void setConfiguration(Configuration configuration) {
//		this.configuration = configuration;
//	}
//	
//
//	
//		
//				
//			
//	
//}
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
