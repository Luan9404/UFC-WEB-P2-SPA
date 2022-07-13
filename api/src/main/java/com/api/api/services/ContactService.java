package com.api.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.api.models.AddContactRequest;
import com.api.api.models.ContactModel;
import com.api.api.models.UserModel;
import com.api.api.repositories.ContactsRepository;

@Service
public class ContactService {
  final ContactsRepository contactsRepository;
  final UserService userService;

  public ContactService(ContactsRepository contactsRepository, UserService userService) {
    this.contactsRepository = contactsRepository;
    this.userService = userService;
  }

  public Iterable<ContactModel> getAll(){
    return contactsRepository.findAll();
  }

  public ContactModel getById(long id){
    return contactsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Transactional
  public UserModel addContact(long userId, AddContactRequest contact){
    UserModel user = userService.getById(userId);
    UserModel contactUser = userService.getByPhoneNumber(contact.getPhoneNumber());    
    contactsRepository.save(new ContactModel(contact.getName(), user, contactUser));
    
    return user;
  }

  @Transactional
  public ContactModel update(ContactModel newContactsData){
    ContactModel contacts = contactsRepository.findById(newContactsData.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    BeanUtils.copyProperties(newContactsData, contacts);

    return contactsRepository.save(contacts);
  }

  public void delete(long id){
    contactsRepository.deleteById(id);
  } 
  
}
