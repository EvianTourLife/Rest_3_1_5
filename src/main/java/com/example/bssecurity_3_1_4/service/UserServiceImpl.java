package com.example.bssecurity_3_1_4.service;


import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService,UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("user не существует");
        }
//        return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
//                user.get().getPassword(),user.get().getAuthorities());
        return user.get();
    }


    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void addUser(User user) {
//        user.setUsername("");
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
         userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
