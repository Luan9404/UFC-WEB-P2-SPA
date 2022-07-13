package com.api.api.controllers;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.models.AddContactRequest;
import com.api.api.models.ResponseModel;
import com.api.api.models.UserModel;
import com.api.api.services.ContactService;
import com.api.api.services.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
  
  private final UserService userService;
  private final JwtEncoder encoder;
  private final ContactService contactService;

  public UserController(UserService userService, ContactService contactService, JwtEncoder encoder) {
    this.userService = userService;
    this.contactService = contactService;
    this.encoder = encoder;
  }

  @GetMapping
  public ResponseEntity<Iterable<UserModel>> getAllUsers(){
    return ResponseEntity.ok(userService.getAll());
  }

  @PostMapping("/register")
  public ResponseEntity<ResponseModel> createUser(@RequestBody UserModel user){
    UserModel result = userService.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel(true, result));
  }

  @PostMapping("/{userId}/add-contact")
  public UserModel addContact(
    @RequestBody AddContactRequest contactRequest, 
    @PathVariable(name = "userId") long userId
  ){
      return contactService.addContact(userId, contactRequest); 
  }
  @GetMapping("/token")
    public String token(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 36000L;
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
