package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.Ligne;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LigneRepo extends MongoRepository<Ligne,String> {

    void deleteByNum(String num);
    Optional<Ligne> findByNum(String num); // pour vérifier s’il existe



}
