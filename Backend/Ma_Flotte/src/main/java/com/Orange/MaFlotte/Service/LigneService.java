package com.Orange.MaFlotte.Service;



import com.Orange.MaFlotte.Model.Ligne;
import com.Orange.MaFlotte.Repo.LigneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneService {

    @Autowired
    private LigneRepo ligneRepo;

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
}
