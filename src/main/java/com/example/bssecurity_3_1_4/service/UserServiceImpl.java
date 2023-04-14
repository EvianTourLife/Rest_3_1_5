package com.example.bssecurity_3_1_4.service;


import com.example.bssecurity_3_1_4.model.Role;
import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.repository.RoleRepository;
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
    private final RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
        user.setUsername(user.getEmail());
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
//        user.setUsername(user.getEmail());
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

    @Override
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

}
