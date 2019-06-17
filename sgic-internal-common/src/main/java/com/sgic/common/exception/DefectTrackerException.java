package com.sgic.common.exception;


public class DefectTrackerException extends Exception {

  private static final long serialVersionUID = 4L;
  private Integer errorCode;
  private String serviceName;
  public DefectTrackerException() {
    super();
  }

  public DefectTrackerException(String message, Integer errorCode) {
    super(message);
    setErrorCode(errorCode);
  }

  public DefectTrackerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public DefectTrackerException(String message, Throwable cause) {
    super(message, cause);
  }

  public DefectTrackerException(String message) {
    super(message);
  }

  public DefectTrackerException(Throwable cause) {
    super(cause);
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

public String getServiceName() {
	return serviceName;
}

public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
  
  
}
