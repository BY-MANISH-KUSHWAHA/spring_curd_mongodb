package com.spring.curd.mongodb.springmongo.controller;


import com.spring.curd.mongodb.springmongo.model.User;
import com.spring.curd.mongodb.springmongo.service.UserQueryService;
import com.spring.curd.mongodb.springmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assignment")
public class UserQueryController {
    @Autowired
    UserQueryService queryService;

    @PostMapping("/saveAllUser")
    public ResponseEntity<?> saveUser(@RequestBody List<User> users){
        queryService.saveAllUser(users);
        return new ResponseEntity<>("All Users added successfully", HttpStatus.OK);
    }

    @GetMapping
    public List<User> allUserDefault(){
        return queryService.findAllUser();
    }

    /*
    db.employee.find({
    name:"Steve"
    })
     */
    @GetMapping("/{userName}")
    public List<User> deleteUser(@PathVariable("userName") String userName){
        return queryService.findUserByName(userName);
    }

    /*
    db.employee.find(
     {  },
     { name:1,age:1,"phone.personal":1,"phone.work":1 }
    )
     */
    @GetMapping("/customFields")
    public List<User> getCustomFields(){
        return queryService.getUserByCustomFields();
    }

    /*
    db.employee.find(
    {privileges: {$regex : ".*min.*"}}
     */

    @PostMapping(value = "/regex")
    public List<User> Segex(@RequestBody Map<String,Object> obj){
        return queryService.regex((String) obj.get("privileges"));
    }

    //Write a query to find the different kinds of points available in points collection under employee collection?
    //db.employee.distinct("points.points")
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% PENDING %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    /*
    //Write a query to find the count of total number of points of all the employees in the collection ?
    db.employee.aggregate([
        {
         $addFields: {
           totalpoints: { $sum: "$points.points" } ,
           totalbonus: { $sum: "$points.bonus" }
         }
       },
       {
         $addFields: { totalScore:
           { $add: [ "$totalpoints", "$totalbonus"] } }
       }
    ])
     */
//    @GetMapping("/aggregatorCall")
//    public List<User> getAggregationCall(){
//        return queryService.aggregationCall();
//    }// Still pending




}
