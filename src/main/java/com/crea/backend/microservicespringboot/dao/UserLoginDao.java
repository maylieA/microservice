package com.crea.backend.microservicespringboot.dao;

import java.util.HashMap;
import java.util.Map;

public class UserLoginDao {
    private Map<String, String> userLoginData;

    public UserLoginDao() {
        userLoginData = new HashMap<>();
        userLoginData.put("john_doe", "password123");
        userLoginData.put("jane_doe", "securePassword");
    }

    public boolean isValidLogin(String login, String password) {
        String storedPassword = userLoginData.get(login);
        return storedPassword != null && storedPassword.equals(password);
    }
}
