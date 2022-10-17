package com.spring.curd.mongodb.springmongo.repository;

import com.spring.curd.mongodb.springmongo.model.User;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQueryRepository extends MongoRepository<User, String> {
    @Query("{name:\"?0\"}")
    public List<User> getUsersByName(String name);

    @Query(value = "{}", fields = "{name: 1, age: 1,'phone.personal': 1,'phone.work': 1}")
    List<User> getCustomField();

    @Query(value="{privileges:{$regex : \"?0\"}}")
    public List<User> regex(String privileges);

    @Aggregation("{$addFields: {\n" +
            "      total: {\n" +
            "        $add: [\n" +
            "          {\n" +
            "            $sum: \"$points.points\"\n" +
            "          },\n" +
            "          {\n" +
            "            $sum: \"$points.bonus\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }}")
    public List<User> withNewField();





}
