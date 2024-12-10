package com.example.Springwithdb.Reposetory;
// this is me repo class this is interface that extends with mongodbrepository so now in my repo interface have all the method which have in mongodb


import com.example.Springwithdb.Model.MyModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Myrepo extends MongoRepository<MyModel , String> {
}
