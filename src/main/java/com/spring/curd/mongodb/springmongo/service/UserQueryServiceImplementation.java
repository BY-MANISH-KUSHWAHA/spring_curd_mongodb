package com.spring.curd.mongodb.springmongo.service;


import com.spring.curd.mongodb.springmongo.model.User;
import com.spring.curd.mongodb.springmongo.repository.UserQueryRepository;
import com.spring.curd.mongodb.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryServiceImplementation implements UserQueryService{
    @Autowired
    UserQueryRepository queryRepository;

    @Override
    public List<User> saveAllUser(List<User> users) {
        return queryRepository.saveAll(users);
    }

    @Override
    public List<User> findAllUser() {
        return queryRepository.findAll();
    }

    @Override
    public List<User> findUserByName(String name) {
        return queryRepository.getUsersByName(name);
    }

    @Override
    public List<User> getUserByCustomFields() {
        return queryRepository.getCustomField();
    }

    @Override
    public List<User> regex(String privileges) {
        return queryRepository.regex(privileges);
    }

    @Override
    public List<User> aggregationCall() {
        return queryRepository.withNewField();
    }
}
