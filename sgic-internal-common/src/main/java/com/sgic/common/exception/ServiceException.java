package com.sgic.common.exception;

public class ServiceException extends DefectTrackerException {

  private static final long serialVersionUID = 4L;

  public ServiceException() {
    super();
  }

  public ServiceException(String message, Integer errorCode) {
    super(message);
    setErrorCode(errorCode);
  }

  public ServiceException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServiceException(String message) {
    super(message);
  }

  public ServiceException(Throwable cause) {
    super(cause);
  }

}
