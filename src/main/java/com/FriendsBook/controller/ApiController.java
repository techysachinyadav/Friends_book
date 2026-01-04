package com.FriendsBook.controller;

import com.FriendsBook.dto.request.RequestDto;
import com.FriendsBook.dto.response.GenericResponseDto;
import com.FriendsBook.dto.response.ResponseDto;
import com.FriendsBook.service.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ClientInterface clientInterface;

    @PostMapping("/register")

    public ResponseEntity<ResponseDto> saveClient(@RequestBody RequestDto requestDto){
        return new ResponseEntity<>(clientInterface.registerClient(requestDto),HttpStatusCode.valueOf(201));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> getClient (@PathVariable Long id){
        return new ResponseEntity<>(clientInterface.getClient(id),HttpStatusCode.valueOf(200));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ResponseDto>> getAllClient(){
        return new ResponseEntity<>(clientInterface.getAllClient(),HttpStatusCode.valueOf(200));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateClient (@PathVariable Long id, @RequestBody RequestDto requestDto){
        return new ResponseEntity<>(clientInterface.updateClient(id, requestDto),HttpStatusCode.valueOf(201));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponseDto> deleteClient(@PathVariable Long id){
        return new ResponseEntity<>(clientInterface.removeClient(id),HttpStatusCode.valueOf(200));
    }
    @GetMapping("/get/{username}")
    public ResponseEntity<ResponseDto> searchByUsername(@PathVariable String username){
        return new ResponseEntity<>(clientInterface.searchByUsername(username),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/containing/{username}")
    public ResponseEntity<List<ResponseDto>> searchByUsernameContaining (@PathVariable String username){
        return new ResponseEntity<>(clientInterface.searchByUsernameContaining(username),HttpStatusCode.valueOf(200));

    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<ResponseDto>> SearchByName (@PathVariable String name){
        return new ResponseEntity<>(clientInterface.searchByName(name),HttpStatusCode.valueOf(200));
    }
}