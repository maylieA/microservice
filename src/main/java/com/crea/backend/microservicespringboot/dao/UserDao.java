package com.crea.backend.microservicespringboot.dao;

import java.util.ArrayList;
import java.util.List;

import com.crea.backend.microservicespringboot.model.Product;
import com.crea.backend.microservicespringboot.model.User;

public class UserDao {
    private List<User> users;

    public UserDao() {
        this.users = new ArrayList<>();
    }

    // Create
    public void addUser(User user) {
        users.add(user);
    }

    // Read
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; 
    }

    public List<User> getAllUsers() {
        return users;
    }

    // Update
    public void updateUser(User user2) {
        for (User user : users) {
            if (user.getId() == user2.getId()) {
                user.setUsername(user2.getUsername());
                user.setEmail(user2.getEmail());
                break;
            }
        }
    }

    // Delete
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    // Add favorite product to user
    public void addFavoriteProduct(User user, Product product) {
        user.addFavoriteProduct(product);
    }

    // Remove favorite product from user
    public void removeFavoriteProduct(User user, Product product) {
        user.removeFavoriteProduct(product);
    }
}
