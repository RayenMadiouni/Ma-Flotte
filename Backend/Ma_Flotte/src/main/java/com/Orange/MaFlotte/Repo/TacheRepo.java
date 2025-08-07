package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.Tache;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TacheRepo extends MongoRepository<Tache,String> {
}
