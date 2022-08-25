package com.maveric.accountservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AccountDto {

    private String accountId;
    private String customerId;
    private String type;
    private String createdAt;
    private String updatedAt;
}
