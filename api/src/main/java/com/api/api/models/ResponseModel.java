package com.api.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {

  @JsonProperty("success")
  private boolean success;
  
  @JsonProperty("data")
  private Object data;
  
  @JsonProperty("message")
  private String message;
  
  public ResponseModel(boolean success, Object data) {
    this.success = success;
    this.data = data;
  }

  public ResponseModel(boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public ResponseModel(boolean success, Object data, String message) {
    this.success = success;
    this.data = data;
    this.message = message;
  }
}
