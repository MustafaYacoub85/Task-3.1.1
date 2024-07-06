package com.example.Task_311.dao;

import com.example.Task_311.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {


}
