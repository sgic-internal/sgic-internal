package com.sgic.internal.product.entities;
//package com.sgic.internal.product.privileges.entities;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@SuppressWarnings("serial")
//@Entity
//@Table(schema="productservice", name="privilegeDetail")
//public class PrivilegeDetail implements Serializable{
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	
//	@ManyToOne
//	@JoinColumn(name="privilegeId", nullable=false)
//	private Privilege privillage;
//	
//	@ManyToOne
//	@JoinColumn(name="roleId", nullable=false)
//	private Role role;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Privilege getPrivillage() {
//		return privillage;
//	}
//
//	public void setPrivillage(Privilege privillage) {
//		this.privillage = privillage;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//	
//	
//	
//}
