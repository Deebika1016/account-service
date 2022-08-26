package com.maveric.accountservice.Methods;

import com.maveric.accountservice.dto.AccountDto;
import com.maveric.accountservice.model.Account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MapModelandDto {
    public static Account toEntity(AccountDto dto) {
        return new Account(
                dto.getAccountId(),
                dto.getCustomerId(),
                dto.getType(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()

        );
    }

    public static AccountDto toDto(Account model) {
        return new AccountDto(
                model.getAccountId(),
                model.getCustomerId(),

                model.getType(),

                model.getCreatedAt(),
                model.getUpdatedAt()
        );
    }
    public static String getCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        String formattedDate=dateFormat.format(date);
        return formattedDate;
    }
}
