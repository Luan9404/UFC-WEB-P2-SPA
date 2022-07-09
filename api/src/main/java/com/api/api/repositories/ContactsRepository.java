package com.api.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.api.models.ContactModel;

public interface ContactsRepository extends CrudRepository<ContactModel, Long>{
  
}
