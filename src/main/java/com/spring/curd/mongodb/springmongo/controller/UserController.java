package com.spring.curd.mongodb.springmongo.controller;

import com.spring.curd.mongodb.springmongo.model.User;
import com.spring.curd.mongodb.springmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    //--------------- Query Based Calls ----------------------------
    @GetMapping("/query/{id}")
    public User getUserByIdQuery(@PathVariable("id") Integer userId){
        return userService.getPlayerByIDQuery(userId);
    }

    @PostMapping("/query/nameAge")
    public List<User> getUserByIdQuery(@RequestBody Map<String,Object> obj){
        return userService.getUserByNameAgeQuery((String) obj.get("name"), (Integer) obj.get("age"));
    }

    @PostMapping("/query/nameAgeCustomField")
    public List<User> getUser3(@RequestBody Map<String,Object> obj){
        return userService.getUser3((String) obj.get("name"), (Integer) obj.get("age"));
    }

    @PostMapping("/query/nameAgeCount")
    public Integer getUser4(@RequestBody Map<String,Object> obj){
        return userService.getUser4((String) obj.get("name"), (Integer) obj.get("age"));
    }

    @PostMapping(value = "/query/nameAgeCount-Json",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser5(@RequestBody Map<String,Object> obj){
        return "{ \"count\":"+userService.getUser4((String) obj.get("name"), (Integer) obj.get("age"))+"}";
    }

    @PostMapping(value = "/query/nameAgeSort")
    public List<User> Sorting(@RequestBody Map<String,Object> obj){
        return userService.Sorting((String) obj.get("name"), (Integer) obj.get("age"));
    }

    @PostMapping(value = "/query/regex")
    public List<User> Segex(@RequestBody Map<String,Object> obj){
        return userService.regex((String) obj.get("name"));
    }

    @PostMapping(value = "/query/embeddedQuery")
    public List<User> embedded(){
        return userService.embeddedValues();
    }

    //-------------- Functions based Calls -----------------------------
    @GetMapping
    public List<User> allUserDefault(){
        return userService.findAllUser();
    }


    @GetMapping("/findAllUser")
    public List<User> allUser(){
        return userService.findAllUser();
    }

    @GetMapping("/{userName}")
    public List<User> getUserByName(@PathVariable("userName") String name){
        return userService.findByName(name);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

    @PostMapping("/saveAllUser")
    public ResponseEntity<?> saveUser(@RequestBody List<User> users){
        userService.saveAllUser(users);
        return new ResponseEntity<>("All Users added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId){
        userService.DeleteUserById(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }



}
