package com.FriendsBook.repository;

import com.FriendsBook.dto.response.ResponseDto;
import com.FriendsBook.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository <Client,Long > {

    Client searchByUsername(String username);
    List<Client> searchByUsernameContaining(String username);
    List<Client> searchByName (String name);
}
