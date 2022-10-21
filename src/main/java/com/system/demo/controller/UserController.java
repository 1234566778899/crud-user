package com.system.demo.controller;

import com.system.demo.entities.User;
import com.system.demo.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository repo;
    @PostMapping("/add")
    public User add(@RequestBody User val){
        return repo.save(val);
    }
    @GetMapping("/lista")
    public List<User> getUsers(){
        return repo.findAll();
    }

    @GetMapping("/view/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return repo.findById(id);
    }
    @PutMapping("/edit")
    public User editar(@RequestBody User user){
        return repo.save(user);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        repo.deleteById(id);
        return "id: "+id+" eliminado";
    }
}
