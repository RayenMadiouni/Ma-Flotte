package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.Affectation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AffectationRepo extends MongoRepository<Affectation,String> {
}
