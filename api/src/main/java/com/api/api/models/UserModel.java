package com.api.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User")
public class UserModel implements Serializable{
  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;
  
  @Column(nullable = false)
  private String phoneNumber;

  @Column(nullable = true)
  private String picUrl;

  @JsonManagedReference(value = "contacts")
  @OneToMany(mappedBy = "userId")
  private List<ContactModel> contacts = new ArrayList<ContactModel>();
 
  @JsonManagedReference(value = "contactOf")
  @OneToMany(mappedBy = "contactUserId")
  private List<ContactModel> contactOn = new ArrayList<ContactModel>();
  
  @JsonManagedReference(value="sendMessages")
  @OneToMany(mappedBy = "sendingUserId")
  private List<MessageModel> sendedMessages = new ArrayList<MessageModel>();
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<ContactModel> getContacts() {
    return contacts;
  }

  public void setContacts(List<ContactModel> contacts) {
    this.contacts = contacts;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  public List<ContactModel> getContactOn() {
    return contactOn;
  }

  public void setContactOn(List<ContactModel> contactOn) {
    this.contactOn = contactOn;
  }

  public List<MessageModel> getSendedMessages() {
    return sendedMessages;
  }

  public void setSendedMessages(List<MessageModel> sendedMessages) {
    this.sendedMessages = sendedMessages;
  }
}
