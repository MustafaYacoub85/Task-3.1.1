package com.example.Task_311.service;
import com.example.Task_311.dao.UserDao;
import com.example.Task_311.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    @Override
    public Iterable<User> getAllUser() {
        return this.userDao.findAll();
    }

    @Override
    public User creatUser(int age, String email, String firstName, String lastName) {
         return this.userDao.save(new User(null,age,email,firstName,lastName));
    }

    @Override
    public Optional<User> findUser(Integer userId) {
        return this.userDao.findById(userId);
    }

    @Override
    public void updateUser(Integer id, int age, String firstName, String lastName, String email) {
        this.userDao.findById(id).ifPresentOrElse(user ->{
            user.setAge(age);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
        }, ()->{throw new NoSuchElementException();
        });
    }

    @Override
    public void deleteUser(Integer id) {
        this.userDao.deleteById(id);
    }


}





