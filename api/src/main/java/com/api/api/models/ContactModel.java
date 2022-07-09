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

@Entity
@Table(name = "contacts")
public class ContactModel implements Serializable{
  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private long contactOf;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "contactId")
  private List<MessageModel> messages = new ArrayList<MessageModel>();

  @ManyToOne
  @JoinColumn(name = "userId")
  private UserModel userId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getContactOf() {
    return contactOf;
  }

  public void setContactOf(long contactOf) {
    this.contactOf = contactOf;
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
}
