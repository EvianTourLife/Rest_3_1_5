package com.example.bssecurity_3_1_4.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Строка имя не должна быть пустым")
    @Size(message = "Имя должно быть от 2-ух до 50 символов")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Строка фамилия не должна быть пустым")
    @Size(message = "Фамилия должна быть от 2-ух до 50 символов")
    @Column(name = "last_name")
    private String surname;

    //    @Min(value = 0, message = "минимум 0")
    @Column(name = "age")
    private Integer age;

    @Column(name = "password")
    @NotEmpty(message = "Строка не должна быть пустой")
    @Size(message = "Строка не должна быть пустой")
    private String password;
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    @Size(message = "Эл. почта должна быть от 2-ух до 50 символов")
    @NotEmpty(message = "Эл. почта не должна быть пустым")
    @Email(message = "некорректная эл. почта")
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public User(String name, String surname, Integer age, String password, String username, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public User() {
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Role> roles1 = roles;
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles1) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }

    public String getAllRolesAsString() {
        StringBuilder finishedString = new StringBuilder();
        for (Role role : roles) {
            finishedString.append(role.getRole()).append(", ");
        }

        return finishedString.substring(0, finishedString.length() - 2);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
