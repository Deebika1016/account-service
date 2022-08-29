package com.maveric.accountservice.controller;
import com.maveric.accountservice.service.AccountService;
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


   @DeleteMapping("/customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String customerId, @PathVariable String accountId){
        String result = accountService.deleteAccount(accountId);
       return new ResponseEntity<String>(result, HttpStatus.OK);
   }

}
