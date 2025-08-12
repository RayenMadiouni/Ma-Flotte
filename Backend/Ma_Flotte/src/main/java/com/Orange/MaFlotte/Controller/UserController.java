package com.Orange.MaFlotte.Controller;


import com.Orange.MaFlotte.Model.Flotteur;
import com.Orange.MaFlotte.Model.User;
import com.Orange.MaFlotte.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userRepo.save(user);
    }
    @GetMapping("/all")
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
    @GetMapping("/exists/{num}")
    public boolean checkIfUserExists(@PathVariable("num") String num) {
        return userRepo.existsByUserNum(num);
    }





}
