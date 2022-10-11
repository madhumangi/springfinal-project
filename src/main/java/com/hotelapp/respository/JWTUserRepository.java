package com.hotelapp.respository;

import com.hotelapp.model.JWTUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTUserRepository extends JpaRepository<JWTUser,Integer> {

    public JWTUser findByUsername(String username);

}
