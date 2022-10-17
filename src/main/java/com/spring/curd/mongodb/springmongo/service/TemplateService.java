package com.spring.curd.mongodb.springmongo.service;

import com.spring.curd.mongodb.springmongo.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TemplateService {
    List<User> findUserByField(String id, String name, String age, String privileges, int page);

    List<User> findUserByName(String name);

    List<User> getAllUserWithCustomeField();

    List<User> getUsersByRegex(String regex);

    List<Integer> getDistinctValue(String field);
}
