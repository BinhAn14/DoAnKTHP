package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}