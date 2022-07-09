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

@Entity
@Table(name = "messagens")
public class MessageModel implements Serializable{
  
  @Id
  @GeneratedValue
  private long id;  
 
  @ManyToOne
  @JoinColumn(name = "contactId")
  private ContactModel contactId;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private Date sendDate;

  @Column(nullable = false)
  private boolean isReaded;
}
