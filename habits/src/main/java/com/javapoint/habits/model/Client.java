package com.javapoint.habits.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "public", name = "users") //у вас свои схемы поэтому название схемы надо изменить, больше я ничего не меняла
public class Client {

    @Id
    @Column(name = "id", nullable = false, unique=true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    @NotBlank(message = "Specify your username")
    @Size(min = 5, max = 50)
    private String username;
    @Column(name = "password")
    @NotBlank(message = "You must have a password")
    @Size(min = 8, max = 20)
    private String password;

    @Column(name = "email")
    @NotBlank(message = "Enter your email")
    private String email;
    @Column(name="enabled")
    private boolean active;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void setRole(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email;}

}
