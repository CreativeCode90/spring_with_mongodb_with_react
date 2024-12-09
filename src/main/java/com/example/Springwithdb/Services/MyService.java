package com.example.Springwithdb.Services;

import com.example.Springwithdb.Model.MyModel;
import com.example.Springwithdb.Reposetory.Myrepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyService {
    @Autowired
    private Myrepo mongorepo;

    //save data in mongodb
    public void saveData(MyModel model){
        mongorepo.save(model);
    }

    //show all data from mongo
    public List<MyModel> getAll(){
        return mongorepo.findAll();
    }

//    show only one data
    public Optional<MyModel> getById(String id){
        return mongorepo.findById(id);
    }

//    make a delete one data
    public Optional<MyModel> deleteById(String id){
        Optional<MyModel> model = mongorepo.findById(id);
        model.ifPresent(e -> mongorepo.deleteById(id));
        return model;
    }

}
