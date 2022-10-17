package com.spring.curd.mongodb.springmongo.repository;
import com.spring.curd.mongodb.springmongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserMongoTemplateRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    // find user by Field
    public List<User> findUserByField(String id, String name, String age, String privileges, Pageable pageable){
        final Query query = new Query().with(pageable);

        // Only this field show in response and rest are null
        query.fields().include("id").include("name");

        final List<Criteria> criteria = new ArrayList<>();
        // if field present in request and take into their query with end operator.
        if(name!=null && !name.isEmpty()){
            criteria.add(Criteria.where("name").is(name));
        }
        if(id!=null && !id.isEmpty()){
            criteria.add(Criteria.where("id").is(id));
        }
        if(age!=null && !age.isEmpty()){
            int age_ = Integer.parseInt(age);
            criteria.add(Criteria.where("age").is(age_));
        }
        if(privileges!=null && !privileges.isEmpty()){
            criteria.add(Criteria.where("privileges").is(privileges));
        }

        // take all conditions and use "AND" Operator.
        if(!criteria.isEmpty()) query.addCriteria(
                new Criteria().andOperator(
                        criteria.toArray(
                                new Criteria[criteria.size()]
                        )
                )
        );

        return mongoTemplate.find(query,User.class);
    }


    // Query 1: findByName
    public List<User> findByName(String name){
        final Query query =new Query();

        query.fields().include("id").include("name").include("age");

        final List<Criteria> criteria = new ArrayList<>();
        // if field present in request and take into their query with end operator.
        if(name!=null && !name.isEmpty()){
            criteria.add(Criteria.where("name").is(name));
        }

        // take all conditions and use "AND" Operator.
        if(!criteria.isEmpty()) query.addCriteria(
                new Criteria().andOperator(
                        criteria.toArray(
                                new Criteria[criteria.size()]
                        )
                )
        );
        return mongoTemplate.find(query,User.class);
    }

    // Quer 2: //Write a query to display the fields name, age and phone with only personal and work for all the documents in the collection employee.
    public List<User> GetAllUserWithCustomeFields(){
        final Query query =new Query();

        query.fields().include("name").include("age").include("phone.personal").include("phone.work");

        return mongoTemplate.find(query,User.class);

    }

    //// Write a query to find an employee with the name contain 'min' as three letters somewhere in his name using regex.
    //db.employee.find(
    //    {privileges: {$regex : ".*min.*"}}
    //)
    public List<User> quer3(String regex){
        final Query query =new Query();

        final List<Criteria> criteria = new ArrayList<>();
        // if field present in request and take into their query with end operator.
        if(regex!=null && !regex.isEmpty()){
            criteria.add(Criteria.where("privileges").regex(regex));
        }

        if(!criteria.isEmpty()) query.addCriteria(
                new Criteria().andOperator(
                        criteria.toArray(
                                new Criteria[criteria.size()]
                        )
                )
        );
        return mongoTemplate.find(query,User.class);


    }

    /*
    //Write a query to find the different kinds of points available in points collection under employee collection?
db.employee.distinct("points.points")
     */
    public List<Integer> query4(String field){
        final Query query =new Query();
        query.fields().include(field);
        return mongoTemplate.query(User.class).distinct(field).as(Integer.class).all();
    }

}
