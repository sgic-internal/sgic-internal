package com.sgic.common.api.enums;

public enum RestApiResponseStatus {

  OK("OK", 20000), CREATED("CREATED", 20100), VALIDATION_FAILURE("VALIDATION_FAILURE", 40000), FORBIDDEN("FORBIDDEN",
      40300), ERROR("ERROR", 50000);

  private String status;

  private Integer code;

  RestApiResponseStatus(String status, Integer code) {
    this.status = status;
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public Integer getCode() {
    return code;
  }

  @Override
  public String toString() {
    return status + ":" + code;
  }

}
