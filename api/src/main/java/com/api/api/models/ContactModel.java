package com.api.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "contacts")
public class ContactModel implements Serializable{
  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String name;
  
  @JsonManagedReference(value = "messages")
  @OneToMany(mappedBy = "contactId")
  private List<MessageModel> messages = new ArrayList<MessageModel>();

  @JsonBackReference(value = "contacts")
  @ManyToOne
  @JoinColumn(name = "userId")
  private UserModel userId;

  @JsonBackReference(value = "contactOf")
  @ManyToOne
  @JoinColumn(name = "contactUserId")
  private UserModel contactUserId;
  
  public ContactModel() {
  }

  public ContactModel(String name, UserModel userId, UserModel contactUserId) {
    this.name = name;
    this.userId = userId;
    this.contactUserId = contactUserId;
  }


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

  public List<MessageModel> getMessages() {
    return messages;
  }

  public void setMessages(List<MessageModel> messages) {
    this.messages = messages;
  }

  public UserModel getUserId() {
    return userId;
  }

  public void setUserId(UserModel userId) {
    this.userId = userId;
  }

  public UserModel getContactUserId() {
    return contactUserId;
  }

  public void setContactUserId(UserModel contactUserId) {
    this.contactUserId = contactUserId;
  }

  
}
