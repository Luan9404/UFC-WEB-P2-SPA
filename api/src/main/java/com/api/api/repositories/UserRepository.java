package com.api.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.api.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long>{
  
}
