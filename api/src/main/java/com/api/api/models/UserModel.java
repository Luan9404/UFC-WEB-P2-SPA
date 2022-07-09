package com.api.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

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

  @OneToMany(mappedBy = "userId")
  private List<ContactModel> contacts = new ArrayList<ContactModel>();

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

}
