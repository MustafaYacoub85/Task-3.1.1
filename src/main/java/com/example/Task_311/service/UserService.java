package com.example.Task_311.service;

import com.example.Task_311.model.User;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Iterable<User> getAllUser();
    User creatUser(int age, String email, String firstName, String lastName);
    Optional<User> findUser(Integer userId);
    void updateUser(Integer id, int age, String firstName, String lastName, String email);
    void deleteUser(Integer id);
    public User updateUser(User user);



}
