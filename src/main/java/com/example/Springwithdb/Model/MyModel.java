package com.example.Springwithdb.Model;
/*
This is Model class java file 
the create document for database 
i have a some datas like is , username , email , password i want to make a curd Application

in this model user can give username , email and password and they data store in mongodb
*/
import com.example.Springwithdb.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Login_users_model")
public class MyModel {
    @Id //this is primery id annotastion
    private String _id;
    private String username;
    private String email;
    private String password;
// get id 
    public String getId() {
        return _id;
    }
// set id 
    public void setId(String id) {
        this._id = id;
    }
// get username
    public String getUsername() {
        return username;
    }
// set username
    public void setUsername(String username) {
        this.username = username;
    }
// get email
    public String getEmail() {
        return email;
    }
// set email
    public void setEmail(String email) {
        this.email = email;
    }
// get password
    public String getPassword() {
        return password;
    }
// set password
    public void setPassword(String password) {
        this.password = password;
    }
}
