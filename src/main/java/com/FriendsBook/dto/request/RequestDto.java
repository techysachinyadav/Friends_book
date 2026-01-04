package com.FriendsBook.dto.request;

import com.FriendsBook.enums.Gender;
import lombok.Data;

@Data
public class RequestDto {
    private String name;
    private String username;
    private String password;
    private Gender gender;
    private String contactNumber;

}
