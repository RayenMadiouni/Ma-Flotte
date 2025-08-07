package com.Orange.MaFlotte.Repo;
import com.Orange.MaFlotte.Model.Employe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeRepo extends MongoRepository<Employe, String> {
    Optional<Employe> findByIdemploye(String idemploye);
}






