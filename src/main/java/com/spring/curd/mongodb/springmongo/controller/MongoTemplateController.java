package com.spring.curd.mongodb.springmongo.controller;


import com.spring.curd.mongodb.springmongo.model.User;
import com.spring.curd.mongodb.springmongo.service.UserMongoTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
public class MongoTemplateController {
    @Autowired
    UserMongoTemplateService service;

    @GetMapping("/getUserByFields")
    public ResponseEntity<?>    findUserByFields(@RequestParam(required = false) String id,
                                                 @RequestParam(required = false) String name,
                                                 @RequestParam(required = false) String age,
                                                 @RequestParam(required = false) String privileges,
                                                 @RequestParam int page){
        return ResponseEntity.ok().body(service.findUserByField(id,name, age,privileges,page));
    }

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable("name") String name){
        return service.findUserByName(name);
    }

    @GetMapping("/alluserWithCustomeFields")
    public List<User> getAllUserWithCustomeFields(){
        return service.getAllUserWithCustomeField();
    }


    @GetMapping("/privilegesRegex")
    public ResponseEntity<?> getA(@RequestParam String regex){
        return ResponseEntity.ok().body(service.getUsersByRegex(regex));
    }


    @GetMapping("/distinct/{field}")
    public List<Integer> getDistinctList(@PathVariable("field") String field){
        return service.getDistinctValue(field);
    }


}
