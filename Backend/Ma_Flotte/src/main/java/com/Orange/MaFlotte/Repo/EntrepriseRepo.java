package com.Orange.MaFlotte.Repo;
import com.Orange.MaFlotte.Model.Entreprise;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntrepriseRepo extends MongoRepository<Entreprise,String> {
}
