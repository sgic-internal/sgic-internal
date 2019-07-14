package com.sgic.internal.product.configure.controller.dto;

public class TypeDto {
	// Type Entity -> id
	private long typeId;
	// Type Entity -> name
	private String typeName;
	// Type Entity -> value
	private String typeValue;
	
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeValue() {
		return typeValue;
	}
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	
	
}
