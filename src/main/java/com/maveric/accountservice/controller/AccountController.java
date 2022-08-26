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


    @GetMapping("/customers/{customerId}/accounts")
    public ResponseEntity<List<AccountDto>> getAccountdetails(@PathVariable String customerId, @RequestParam(defaultValue = "0") Integer page,
                                                              @RequestParam(defaultValue = "10") Integer pageSize) {
        List<AccountDto> accountdtoresult = accountService.getAccountDetails();
        return new ResponseEntity<List<AccountDto>>(accountdtoresult, HttpStatus.OK);
    }



  

}
