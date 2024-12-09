package com.example.Springwithdb.Controller;

import com.example.Springwithdb.Model.MyModel;
import com.example.Springwithdb.Services.MyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:5173")
public class MyController {

    private Map<String, MyModel> entry = new HashMap<>();
    @Autowired
    private MyService service;

    @PostMapping("/create")
    //create model
    private boolean create(@RequestBody MyModel model) {
        entry.put(model.getId(), model);
        service.saveData(model);
        return true;
    }

    @GetMapping("/get")
//    show all entry
    public List<MyModel> getAll() {
        return service.getAll();
    }

    @GetMapping("getOne/{id}")
//get one
    public Optional<MyModel> getOne(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("delete/{id}")
//    delete
    public Optional<MyModel> deleteOne(@PathVariable String id){
        return service.deleteById(id);
    }
    
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
