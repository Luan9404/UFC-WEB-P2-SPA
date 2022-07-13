package com.api.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.models.MessageModel;
import com.api.api.models.ResponseModel;
import com.api.api.models.SendMessageRequest;
import com.api.api.services.ContactService;
import com.api.api.services.MessageService;
import com.api.api.services.UserService;

@RestController
@RequestMapping("/api/message")
public class MessageController {
  final UserService userService;
  final MessageService messageService;
  final ContactService contactService;
  
  public MessageController(UserService userService, MessageService messageService, ContactService contactService) {
    this.userService = userService;
    this.messageService = messageService;
    this.contactService = contactService;
  }

  @PostMapping("/{id}/send")  
  public ResponseEntity<ResponseModel> sendMessage(
    @RequestBody SendMessageRequest message,
    @PathVariable(name = "id") long userId
  ){
    messageService.save(message, userId);
    Iterable<MessageModel> messages = messageService.getAll();

    return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(true, messages));
  }
}
