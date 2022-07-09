package com.api.api.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.api.models.UserModel;
import com.api.api.repositories.UserRepository;

@Service
public class UserService {
  final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Iterable<UserModel> getAll(){
    return userRepository.findAll();
  }

  public Optional<UserModel> getById(long id){
    return userRepository.findById(id);
  }

  public UserModel update(UserModel newUserData){
    UserModel user = userRepository.findById(newUserData.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    BeanUtils.copyProperties(newUserData, user);

    return userRepository.save(user);
  }

  public void delete(long id){
    userRepository.deleteById(id);
  }
}
