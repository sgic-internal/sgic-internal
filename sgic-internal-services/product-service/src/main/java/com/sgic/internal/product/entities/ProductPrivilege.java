package com.sgic.internal.product.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "productservice", name = "productPrivilege")
public class ProductPrivilege implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="privilegeId", nullable = false)
	private Privilege privilege;

	private boolean privilegeStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public boolean isPrivilegeStatus() {
		return privilegeStatus;
	}

	public void setPrivilegeStatus(boolean privilegeStatus) {
		this.privilegeStatus = privilegeStatus;
	}

}
