package com.sgic.internal.defecttracker.configure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "defectservices", name = "rolePrivilege")
public class RolePrivileges implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	private Role role;
	@Column(nullable = false)
	private Long productprivilegeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getProductprivilegeId() {
		return productprivilegeId;
	}

	public void setProductprivilegeId(Long productprivilegeId) {
		this.productprivilegeId = productprivilegeId;
	}

}
