package com.api.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "messagens")
public class MessageModel implements Serializable{
  
  @Id
  @GeneratedValue
  private long id;  
  
  @JsonBackReference(value = "messages")
  @ManyToOne
  @JoinColumn(name = "contactId")
  private ContactModel contactId;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private Date sendDate;

  @Column(nullable = false)
  private boolean isReaded;

  @JsonBackReference(value ="sendMessages")
  @ManyToOne
  @JoinColumn(name="sendingUserId",nullable = false)
  private UserModel sendingUserId;
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ContactModel getContactId() {
    return contactId;
  }

  public void setContactId(ContactModel contactId) {
    this.contactId = contactId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getSendDate() {
    return sendDate;
  }

  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }

  public boolean isReaded() {
    return isReaded;
  }

  public void setReaded(boolean isReaded) {
    this.isReaded = isReaded;
  }

  public UserModel getSendingUserId() {
    return sendingUserId;
  }

  public void setSendingUserId(UserModel sendingUserId) {
    this.sendingUserId = sendingUserId;
  }
}
