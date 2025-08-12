package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.Flotteur;
import com.Orange.MaFlotte.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {

        boolean existsByUserNum(String userNum);// <-- num est un attribut dans User
        Optional<User> findByUserNum(String userNum);
    }


