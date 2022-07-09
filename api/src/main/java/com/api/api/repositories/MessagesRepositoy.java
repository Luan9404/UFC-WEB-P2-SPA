package com.api.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.api.models.MessageModel;

public interface MessagesRepositoy extends CrudRepository<MessageModel, Long>{
  
}
