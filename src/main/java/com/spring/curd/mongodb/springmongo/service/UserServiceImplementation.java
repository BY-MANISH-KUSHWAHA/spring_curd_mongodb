package com.spring.curd.mongodb.springmongo.service;

import com.spring.curd.mongodb.springmongo.model.User;
import com.spring.curd.mongodb.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> findByName(String name) {
        return userRepo.findByName(name);// function come from UserRepository
    }


    @Override
    public void DeleteUserById(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user); // Coming from CrudRepository
    }

    @Override
    public List<User> saveAllUser(List<User> users) {
        return userRepo.saveAll(users);
    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }



    // ------------------ Quiers ---------------------------------
    @Override
    public User getPlayerByIDQuery(Integer id) {
        return userRepo.getPlayerByIdQuery(id);
    }

    @Override
    public List<User> getUserByNameAgeQuery(String name, Integer age) {
        return userRepo.getUserByNameAgeQuery(name,age);
    }

    @Override
    public List<User> getUser3(String name, Integer age) {
        return userRepo.getUser3(name,age);
    }

    @Override
    public Integer getUser4(String name, Integer age) {
        return userRepo.getUser4(name,age);
    }

    @Override
    public List<User> Sorting(String name, Integer age) {
        return userRepo.sorting(name,age);
    }

    @Override
    public List<User> regex(String name) {
        return userRepo.regex(name);
    }

    @Override
    public List<User> embeddedValues() {
        return userRepo.showEmbedded();
    }
}
