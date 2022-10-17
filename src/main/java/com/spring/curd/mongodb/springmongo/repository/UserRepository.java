package com.spring.curd.mongodb.springmongo.repository;


import com.spring.curd.mongodb.springmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findByName(String name);

    //-------------------- Queries ---------------------------------
    @Query("{id:\"?0\"}")
    public User getPlayerByIdQuery(Integer id);


    @Query("{$and: [{name:?0},{age:?1}]}")
    public List<User> getUserByNameAgeQuery(String name,Integer age);


    @Query(value = "{name : ?0, age : ?1}", fields = "{ \"name\" : 1, \"badges\":1}")
    public List<User> getUser3(String name,Integer age);

    @Query(value = "{name : ?0, age : ?1}", count = true)
    public Integer getUser4(String name,Integer age);

    @Query(value = "{name : ?0, age : ?1}",sort = "{age: 1}")// can sort with other param
    public List<User> sorting(String name,Integer age);

    @Query(value="{name:{$regex : \"?0\"}}")
    public List<User> regex(String pattern);

    @Query(value = "{}", fields = "{name: 1, age: 1,'phone.personal': 1,'phone.work': 1}")
    List<User> showEmbedded();
}
