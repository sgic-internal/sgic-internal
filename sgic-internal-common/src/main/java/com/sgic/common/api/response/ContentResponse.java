package com.sgic.common.api.response;

import java.util.HashMap;
import java.util.Map;

import com.sgic.common.api.enums.RestApiResponseStatus;

/**
 * Generic of API content response
 *
 */
public class ContentResponse<T> extends ApiResponse {
  public ContentResponse(RestApiResponseStatus restApiResponseStatus) {
    super(restApiResponseStatus);
  }

  public ContentResponse() {
	  super(RestApiResponseStatus.OK);
  }


  private Map<String, T> content = new HashMap<String, T>();

  public ContentResponse(String key, T dto, RestApiResponseStatus restApiResponseStatus) {
	  super(restApiResponseStatus);
    content.put(key, dto);
  }

  public Map<String, T> getBody() {
    return content;
  }

  public void setBody(String key, T dto) {
    content.put(key, dto);
  }
}
