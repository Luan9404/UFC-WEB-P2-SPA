package com.api.api.models;

import java.util.Date;

public class SendMessageRequest {
  private int contactId;
  private String content;
  private boolean isReaded = false;
  private Date sendDate = new Date();

  public int getContactId() {
    return contactId;
  }
  public void setContactId(int contactId) {
    this.contactId = contactId;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public boolean isReaded() {
    return isReaded;
  }
  public void setReaded(boolean isReaded) {
    this.isReaded = isReaded;
  }
  public Date getSendDate() {
    return sendDate;
  }
  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }
}
