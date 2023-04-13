package com.example.bssecurity_3_1_4.service;


import com.example.bssecurity_3_1_4.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {



    User getById(Long id);
    void addUser(User user);

    void edit(User user);

    List<User> getAll();

    void delete(Long id);

    Optional<User> findByUsername(String username);
}
