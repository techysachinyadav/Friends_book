package com.FriendsBook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;
    private String dob;
    private String profileName;
    private String avatar;

    @JsonIgnore
    @OneToOne(mappedBy = "profile")
    private Client client;




}
