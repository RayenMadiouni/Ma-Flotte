package com.Orange.MaFlotte.Service;



import com.Orange.MaFlotte.DTO.LigneAvecEmployeDTO;
import com.Orange.MaFlotte.Model.Ligne;
import com.Orange.MaFlotte.Repo.LigneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneService {

    @Autowired
    private LigneRepo ligneRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Ligne> getAllLignes() {
        return ligneRepo.findAll();
    }

    public Ligne getLigneById(String id) {
        return ligneRepo.findById(id).orElse(null);
    }

    public Ligne saveLigne(Ligne ligne) {
        return ligneRepo.save(ligne);
    }

    public void deleteLigne(String id) {
        ligneRepo.deleteById(id);
    }

    public List<LigneAvecEmployeDTO> getLignesAvecEmploye() {
        LookupOperation lookup = LookupOperation.newLookup()
                .from("employe")
                .localField("employeId")
                .foreignField("Idemploye")
                .as("employe");

        UnwindOperation unwind = Aggregation.unwind("employe");

        Aggregation aggregation = Aggregation.newAggregation(lookup, unwind);

        return mongoTemplate.aggregate(aggregation, "ligne", LigneAvecEmployeDTO.class).getMappedResults();
    }


}
