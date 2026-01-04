package com.FriendsBook.repository;

import com.FriendsBook.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepository extends JpaRepository <MetaData , Long>{
}
