package com.maveric.accountservice.controller;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.service.AccountService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountService accountService;


   @PostMapping("/customers/{customerId}/accounts")
   public ResponseEntity<Account> createAccount(@PathVariable String customerId, @RequestBody Account account) {
       Account accountdtoresult = accountService.createAccount(account);
       return new ResponseEntity<Account>(accountdtoresult, HttpStatus.CREATED);
   }

    }

