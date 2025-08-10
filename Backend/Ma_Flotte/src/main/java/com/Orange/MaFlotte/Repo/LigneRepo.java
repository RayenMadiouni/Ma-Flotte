package com.Orange.MaFlotte.Repo;

import com.Orange.MaFlotte.Model.Ligne;
import com.Orange.MaFlotte.Model.TypeLigne;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LigneRepo extends MongoRepository<Ligne,String> {

    void deleteByNum(String num);
    Optional<Ligne> findByNum(String num);
    Optional<Ligne> findByNumAndTypeAndEmploye_NomEmployeAndEmploye_PrenomEmploye(String num, TypeLigne type, String nomEmploye, String prenomEmploye);

// pour vérifier s’il existe



}
