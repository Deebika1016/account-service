package com.maveric.accountservice.controller;

import com.maveric.accountservice.dto.AccountDto;
import com.maveric.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
   @PostMapping("/customers/{customerId}/accounts")
   public ResponseEntity<AccountDto> createAccount(@PathVariable String customerId, @RequestBody AccountDto accountDto) {
       AccountDto accountdtoresult = accountService.createAccount(accountDto);
       return new ResponseEntity<AccountDto>(accountdtoresult, HttpStatus.CREATED);
   }
   @GetMapping("/customers/{customerId}/accounts/{accountId}")
   public ResponseEntity<AccountDto> getaccountbtId(@PathVariable String customerId ,@PathVariable String accountId){
        AccountDto result = accountService.getaccountbyId(accountId);
        return new ResponseEntity<AccountDto>(result,HttpStatus.OK);
   }
   @DeleteMapping("/customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String customerId, @PathVariable String accountId){
        String result = accountService.deleteAccount(accountId);
       return new ResponseEntity<String>(result, HttpStatus.OK);
   }
    @PutMapping("customer/{customerId}/accounts/{accountId}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable String customerId,@PathVariable String accountId,@RequestBody AccountDto accountDto) {
        AccountDto accountDtoResponse = accountService.updateaccount(accountId,accountDto);
        return new ResponseEntity<>(accountDtoResponse, HttpStatus.OK);
    }
}
