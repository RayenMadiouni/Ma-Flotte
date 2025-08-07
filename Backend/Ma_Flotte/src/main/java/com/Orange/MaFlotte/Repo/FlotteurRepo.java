package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.Flotteur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FlotteurRepo extends MongoRepository<Flotteur, String> {
    Optional<Flotteur> findByNum(String num);




}
