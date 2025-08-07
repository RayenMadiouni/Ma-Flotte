package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {

        boolean existsByNum(String num); // <-- num est un attribut dans User
    }
