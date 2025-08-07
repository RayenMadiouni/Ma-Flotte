package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FactureRepo extends MongoRepository<Facture,String> {
}
