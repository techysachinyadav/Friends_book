package com.FriendsBook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caption;
    private String location;
    private Long likes;
    private Long comments;
    private String imageUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
}
