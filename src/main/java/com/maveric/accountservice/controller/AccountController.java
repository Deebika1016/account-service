package com.maveric.accountservice.controller;

import com.maveric.accountservice.dto.AccountDto;
import com.maveric.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountService accountService;



   @GetMapping("/customers/{customerId}/accounts/{accountId}")
   public ResponseEntity<AccountDto> getaccountbtId(@PathVariable String customerId ,@PathVariable String accountId){
        AccountDto result = accountService.getaccountbyId(accountId);
        return new ResponseEntity<AccountDto>(result,HttpStatus.OK);
   }


}
