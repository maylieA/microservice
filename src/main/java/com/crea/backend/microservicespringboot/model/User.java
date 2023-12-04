package com.crea.backend.microservicespringboot.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String login;
    private String password;
    private List<Product> favoriteProducts;

    public User(int id, String username, String email, String login, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.login = login;
        this.password = password;
        this.favoriteProducts = new ArrayList<>();
    }


    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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

    
    public List<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public void addFavoriteProduct(Product product) {
        favoriteProducts.add(product);
    }

    public void removeFavoriteProduct(Product product) {
        favoriteProducts.remove(product);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", login=" + login + ", password=" + password + "]";
    }
}
