package com.example.bssecurity_3_1_4.service;


import com.example.bssecurity_3_1_4.model.Role;
import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.repository.RoleRepository;
import com.example.bssecurity_3_1_4.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("user не существует");
        }

        return user.get();
    }


    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUsername(user.getEmail());
        userRepository.save(user);
    }

    @Override
    public void edit(User updatedUser) {
        User user = userRepository.getById(updatedUser.getId());
        if (!updatedUser.getPassword().equals(user.getPassword())){
            updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        updatedUser.setUsername(updatedUser.getEmail());
        userRepository.save(updatedUser);

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
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


}
