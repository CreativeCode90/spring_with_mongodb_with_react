package com.example.Springwithdb.Reposetory;


import com.example.Springwithdb.Model.MyModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Myrepo extends MongoRepository<MyModel , String> {
}
