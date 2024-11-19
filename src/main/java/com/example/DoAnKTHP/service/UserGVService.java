package com.example.DoAnKTHP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DoAnKTHP.Repository.GiangVienRepository;
import com.example.DoAnKTHP.Repository.UserRepository;
import com.example.DoAnKTHP.models.GiangVien;
import com.example.DoAnKTHP.models.User;

import jakarta.transaction.Transactional;

@Service
public class UserGVService {

    @Autowired
            private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
