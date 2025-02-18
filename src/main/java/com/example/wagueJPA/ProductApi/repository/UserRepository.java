package com.example.wagueJPA.ProductApi.repository;

import com.example.wagueJPA.ProductApi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
Users findByUserName(String userName);
}
