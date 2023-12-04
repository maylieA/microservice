package com.crea.backend.microservicespringboot.dao;

import com.crea.backend.microservicespringboot.model.UserRegister;
import java.util.ArrayList;
import java.util.List;

public class UserRegisterDao {
    private List<UserRegister> registeredUsers;

    public UserRegisterDao() {
        registeredUsers = new ArrayList<>();
    }

    public void registerUser(UserRegister user) {
        registeredUsers.add(user);
    }

    public boolean isUsernameTaken(String username) {
        for (UserRegister user : registeredUsers) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLoginTaken(String login) {
        for (UserRegister user : registeredUsers) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmailTaken(String email) {
        for (UserRegister user : registeredUsers) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
