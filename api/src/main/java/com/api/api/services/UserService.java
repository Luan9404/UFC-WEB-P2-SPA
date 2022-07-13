package com.api.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.api.models.UserModel;
import com.api.api.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder encoder;
  public UserService(UserRepository userRepository, PasswordEncoder encoder) {
    this.userRepository = userRepository;
    this.encoder = encoder;
  }

  public Iterable<UserModel> getAll(){
    return userRepository.findAll();
  }

  public UserModel getById(long id){
    return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  public UserModel getByPhoneNumber(String phoneNumber){
    return userRepository.findByPhoneNumber(phoneNumber);
  }
  
  public UserModel save(UserModel user){
    user.setPassword(encoder.encode(user.getPassword()));
    return userRepository.save(user);
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
