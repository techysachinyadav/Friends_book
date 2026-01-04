package com.FriendsBook.dto.response;

import com.FriendsBook.enums.Gender;
import lombok.Data;

@Data
public class ResponseDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Gender gender;
    private String contactNumber;

}
