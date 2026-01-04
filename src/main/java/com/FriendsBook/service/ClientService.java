package com.FriendsBook.service;

import com.FriendsBook.dto.request.RequestDto;
import com.FriendsBook.dto.response.GenericResponseDto;
import com.FriendsBook.dto.response.MetaResponseDto;
import com.FriendsBook.dto.response.ProfileResponseDto;
import com.FriendsBook.dto.response.ResponseDto;
import com.FriendsBook.entity.Client;
import com.FriendsBook.entity.MetaData;
import com.FriendsBook.entity.Profile;
import com.FriendsBook.repository.ClientRepository;
import com.FriendsBook.repository.MetaDataRepository;
import com.FriendsBook.repository.PostRepository;
import com.FriendsBook.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ClientService implements ClientInterface{
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private MetaDataRepository metaDataRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
   public ResponseDto registerClient(RequestDto requestDto){

        //comment added
        Client client = mapDtoToEntity(requestDto,new Client());
        Profile profile = new Profile();
        client.setProfile(profile);
        profile.setClient(client);
        MetaData metaData = new MetaData();
        client.setMetaData(metaData);
        metaData.setClient(client);
        clientRepository.save(client);
        return mapEntityToDto(client);
    }

    @Override
    public ResponseDto getClient(Long id){
        Client client = clientRepository.findById(id).orElse(null);
        if (client!=null) {
            return mapEntityToDto(client);
        }
        else {
            return null;
        }
    }

    @Override
    public List<ResponseDto> getAllClient() {
        List<Client> userlist = clientRepository.findAll();
        List<ResponseDto> userResponseList = new LinkedList<>();
        for (Client client : userlist) {
            userResponseList.add(mapEntityToDto(client));
        }
            return userResponseList;


    }

    @Override
    public ResponseDto updateClient(Long id, RequestDto requestDto) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client!= null){
            mapDtoToEntity(requestDto,client);
            clientRepository.save(client);
            return mapEntityToDto(client);
        }
        else {
            return null;
        }
    }

    @Override
    public GenericResponseDto removeClient(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        if (client!=null){
           String name= client.getName();
            clientRepository.deleteById(id);
            genericResponseDto.setSuccess(true);
            genericResponseDto.setMessage(name + "Client and the id is "+id+"is deleted");
        }
        else {
            genericResponseDto.setSuccess(false);
            genericResponseDto.setMessage("this is not the user");
        }
        return genericResponseDto;
    }

    @Override
    public ResponseDto searchByUsername(String username) {
    Client client = clientRepository.searchByUsername( username);
    if (client!=null){
       return mapEntityToDto(client);
    }
    else{
        return null;

    }

    }

    @Override
    public List<ResponseDto> searchByUsernameContaining(String username) {
        List<Client> clientList = clientRepository.searchByUsernameContaining(username);
        List<ResponseDto> userResponseList = new LinkedList<>();
        for (Client client : clientList){
            userResponseList.add(mapEntityToDto(client));

        }
        return userResponseList;
    }

    @Override
    public List<ResponseDto> searchByName(String name) {
        List<Client> clientList = clientRepository.searchByName(name);
        List<ResponseDto> responseList = new LinkedList<>();
        for (Client client : clientList ){
            responseList.add(mapEntityToDto(client));
        }
        return responseList;
    }


    // helper methods
    public Client mapDtoToEntity(RequestDto requestDto , Client client){
        client.setName(requestDto.getName());
        client.setUsername(requestDto.getUsername());
        client.setPassword(requestDto.getPassword());
        client.setContactNumber(requestDto.getContactNumber());
        client.setGender(requestDto.getGender());
        Profile profile =new Profile();
        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
        profileResponseDto.setProfileName(profile.getProfileName());
        profileResponseDto.setBio(profile.getBio());
        profileResponseDto.setAvatar(profile.getAvatar());
        profileResponseDto.setDob(profile.getDob());
        MetaData metaData = new MetaData();
        MetaResponseDto metaResponseDto=new MetaResponseDto();
        metaResponseDto.setInterestTags(metaData.getInterestTags());
        return client;
    }
    public ResponseDto mapEntityToDto(Client client){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(client.getId());
        responseDto.setName(client.getName());
        responseDto.setUsername(client.getUsername());
        responseDto.setPassword(client.getPassword());
        responseDto.setContactNumber(client.getContactNumber());
        responseDto.setGender(client.getGender());
        return  responseDto;

    }

}
