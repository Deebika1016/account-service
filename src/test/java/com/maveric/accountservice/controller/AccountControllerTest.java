package com.maveric.accountservice.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import com.maveric.accountservice.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import javax.ws.rs.core.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper map;
    @MockBean
    private AccountService mockService;
    @MockBean
    private AccountRepository mockRepo;


    @Test
    void shouldGetAccountsWhenRequestMadeToGetAccounts() throws Exception {
        mvc.perform(get("/api/v1/customers/" + "10" + "/accounts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }}
