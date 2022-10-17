package com.spring.curd.mongodb.springmongo.service;


import com.spring.curd.mongodb.springmongo.model.User;

import java.util.List;

public interface UserQueryService {

    List<User> saveAllUser(List<User> users);

    List<User> findAllUser();

    List<User> findUserByName(String name);

    List<User> getUserByCustomFields();

    List<User> regex(String privileges);

    List<User> aggregationCall();


}
