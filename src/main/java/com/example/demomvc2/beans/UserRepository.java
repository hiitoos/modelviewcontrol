package com.example.demomvc2.beans;

import com.example.demomvc2.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers();
    void addUser(User user);
    void removeUser(User user);
}
