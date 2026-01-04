package com.FriendsBook.service;

import com.FriendsBook.dto.request.RequestDto;
import com.FriendsBook.dto.response.GenericResponseDto;
import com.FriendsBook.dto.response.ResponseDto;
import com.FriendsBook.entity.Client;

import java.util.List;

public interface ClientInterface {
    ResponseDto registerClient(RequestDto requestDto);
    ResponseDto getClient(Long id);
    List<ResponseDto> getAllClient();
    ResponseDto updateClient(Long id , RequestDto requestDto);
    GenericResponseDto removeClient(Long id);
    ResponseDto searchByUsername(String username);
    List<ResponseDto> searchByUsernameContaining(String username);
    List<ResponseDto> searchByName (String name);


}
