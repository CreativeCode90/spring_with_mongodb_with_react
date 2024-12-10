package com.example.Springwithdb.Controller;
/*
    This is Main Controller class 
    this class hundle all the methods for operate task 
    like create data , get all data , get one , update and delete data 
    they all task manage by this contoller class

 */
import com.example.Springwithdb.Model.MyModel;
import com.example.Springwithdb.Services.MyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// am define this controller class is restcontroller 
@RestController
@RequestMapping("/app")  // set the request maping mean my url look like this 
// http://localhost:9090/app
// ____________________________________________________
// this is very importent like @corssorigin set my client url origin for intereact the my client 
// in my case am using react js as a client so my client url is 
// "http://localhost:5173"
@CrossOrigin(origins = "http://localhost:5173")
// _____________________________________________________
public class MyController {
// this is mymodel and wrapping my model in map format
/*
Map<String, MyModel> -> they take two argument 
1 -> id -> but they not take id directly -> give model id data type
//my case my model id type is String ->   private String _id;

2 -> which model wrap -> so give your model
*/
    private Map<String, MyModel> entry = new HashMap<>();
    // use autowired for get object from spring boot
    @Autowired
    // get my service object
    private MyService service;
// create some controllers like port , get , update and delete

// 1-> post controller 
// my url -> http://localhost:9090/app/create
    @PostMapping("/create") //use for post request hundle 
    // @RequestBody tak body json data and pass which data format and set in body so -> this is my format -> MyModel model
    //create model
    private boolean create(@RequestBody MyModel model) {
        // next put my data in map
        // they tak two margument id and data
        entry.put(model.getId(), model);
        // this is my service method 
        // the savedata data is take data which want to save and save in mongodb
        service.saveData(model);
        return true;
    }



// 2-> getAll data controller
// url -> http://localhost:9090/app/get
// my method type is list beacuse amd show all data as list wise amd using list 
    @GetMapping("/get")
//    show all entry
    public List<MyModel> getAll() {
        // service meathod -> get all data
        return service.getAll();
    }

// 3 > get only one data by id 
// url > http://localhost:9090/app/getOne/123445
// this is my data mongodb id -> 123445
// in this method i ask one parameters 
// @PathVariable String id 
// PathVariable > is take data from url path
    @GetMapping("getOne/{id}")
//get one
    public Optional<MyModel> getOne(@PathVariable String id) {
        return service.getById(id);
    }

// 4 > delete by id dethod
// the meatod delete data byid only one data remove 
// my url -> http://localhost:9090/app/delete/1234
    @DeleteMapping("delete/{id}")
//    delete
    public Optional<MyModel> deleteOne(@PathVariable String id){
        return service.deleteById(id);
    }
    
// 5> put method this is update method
// update only one data byid
// when i want to do update data entry so i want two parameters
// like 1> which data you want to update so define as id > when you give id so they find this data you update by the id .
// 2> what are update from the model like update username , pass and email so define here you model
// my url -> http://localhost:9090/app/update/1234
    @PutMapping("update/{id}")
//    update
    public MyModel updateOne(@PathVariable String id , @RequestBody MyModel model){
        Optional<MyModel> old_model = service.getById(id);
        if(old_model.isPresent()){
            MyModel new_model = old_model.get();
            new_model.setUsername(model.getUsername()!=null & model.getUsername().equals("") ? model.getUsername() : model.getUsername()  );
            new_model.setEmail(model.getEmail()!=null & model.getEmail().equals("") ? model.getEmail() : model.getEmail()  );
            new_model.setPassword(model.getPassword()!=null & model.getPassword().equals("") ? model.getPassword() : model.getPassword()  );
            service.saveData(new_model);
        }
        return (MyModel) entry;
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to spring boot journy";
    }

}
