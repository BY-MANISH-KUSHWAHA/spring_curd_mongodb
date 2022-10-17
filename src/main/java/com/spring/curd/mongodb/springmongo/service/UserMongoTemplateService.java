package com.spring.curd.mongodb.springmongo.service;
import com.spring.curd.mongodb.springmongo.model.User;
import com.spring.curd.mongodb.springmongo.repository.UserMongoTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMongoTemplateService implements TemplateService {
    @Autowired
    UserMongoTemplateRepository templateRepository;

    @Override
    public List<User> findUserByField(String id, String name, String age, String privileges, int page) {
        // page: 1 => 15 records
        // page: 0 => 1 required based on size define (in our case size:1 )
        return templateRepository.findUserByField(id,name,age,privileges, PageRequest.of(page,1));
    }

    @Override
    public List<User> findUserByName(String name) {
        return templateRepository.findByName(name);
    }

    @Override
    public List<User> getAllUserWithCustomeField(){
        return templateRepository.GetAllUserWithCustomeFields();
    }

    @Override
    public List<User> getUsersByRegex(String regex) {
        return templateRepository.quer3(regex);
    }

    @Override
    public List<Integer> getDistinctValue(String field) {
        return templateRepository.query4(field);
    }


}
