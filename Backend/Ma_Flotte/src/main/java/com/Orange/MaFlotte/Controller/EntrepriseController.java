package com.Orange.MaFlotte.Controller;

import com.Orange.MaFlotte.Model.Entreprise;
import com.Orange.MaFlotte.Repo.EntrepriseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprise")

public class EntrepriseController {

    @Autowired
    EntrepriseRepo entrepriseRepo;
    @PostMapping("/add")
    public void addEntreprise(@RequestBody Entreprise entreprise){entrepriseRepo.save(entreprise);}

    @GetMapping("/all")
    public List<Entreprise> getAllEntreprise() {
        return entrepriseRepo.findAll();
    }

}
