package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.Poste;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PosteRepo extends MongoRepository<Poste,String> {
}
