package com.api.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.api.api.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long>{
  @Query("SELECT u FROM UserModel u WHERE u.phoneNumber = :number")
  public abstract UserModel findByPhoneNumber(@Param("number") String phoneNumber);

  @Query("SELECT u FROM UserModel u WHERE u.email = :email")
  public abstract Optional<UserModel> findByEmail(@Param("email") String email);
}
