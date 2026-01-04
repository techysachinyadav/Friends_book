package com.FriendsBook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "meta_data")
public class MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String interestTags;

    @JsonIgnore
    @OneToOne(mappedBy = "metaData")
    private Client client;
}
