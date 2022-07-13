package com.api.api.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.api.models.MessageModel;
import com.api.api.models.SendMessageRequest;
import com.api.api.repositories.MessagesRepositoy;

@Service
public class MessageService {
  final MessagesRepositoy messageRepository;
  final ContactService contactService;
  final UserService userService;

  public MessageService(MessagesRepositoy messageRepository, ContactService contactService, UserService userService) {
    this.messageRepository = messageRepository;
    this.contactService = contactService;
    this.userService = userService;
  }

  public Iterable<MessageModel> getAll(){
    return messageRepository.findAll();
  }

  public Optional<MessageModel> getById(long id){
    return messageRepository.findById(id);
  }

  @Transactional
  public void save(SendMessageRequest message, long userId){
    var repositoriMessage = new MessageModel();
    var contact = contactService.getById(message.getContactId());
    var sendingUser = userService.getById(userId);
    BeanUtils.copyProperties(message, repositoriMessage);
    repositoriMessage.setSendingUserId(sendingUser);
    repositoriMessage.setContactId(contact);

    messageRepository.save(repositoriMessage);
  }

  @Transactional
  public MessageModel update(MessageModel newMessageData){
    MessageModel message = messageRepository.findById(newMessageData.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    BeanUtils.copyProperties(newMessageData, message);

    return messageRepository.save(message);
  }

  public Iterable<MessageModel> getContactMessages(long contactId){
    return messageRepository.getContactMessages(contactId);
  }
  
  public void delete(long id){
    messageRepository.deleteById(id);
  }
}
