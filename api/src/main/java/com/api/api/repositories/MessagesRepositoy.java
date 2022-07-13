package com.api.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.api.api.models.MessageModel;

public interface MessagesRepositoy extends CrudRepository<MessageModel, Long>{
  @Query("SELECT m FROM MessageModel m WHERE m.contactId = :id")
  public abstract Iterable<MessageModel> getContactMessages(@Param("id") long id);
}
