package com.spring.curd.mongodb.springmongo.service;

import com.spring.curd.mongodb.springmongo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> findByName(String name);
    void DeleteUserById(String id);
    User saveUser(User user);

    List<User> saveAllUser(List<User> users);

    List<User> findAllUser();


    User getPlayerByIDQuery(Integer Id);

    List<User> getUserByNameAgeQuery(String name,Integer age);

    List<User> getUser3(String name,Integer age);// custom field

    Integer getUser4(String name,Integer age);// custom field


    List<User> Sorting(String name,Integer age);// custom field


    List<User> regex(String name);

    List<User> embeddedValues();



}
