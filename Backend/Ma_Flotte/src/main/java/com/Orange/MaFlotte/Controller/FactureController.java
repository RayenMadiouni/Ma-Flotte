package com.Orange.MaFlotte.Controller;

import com.Orange.MaFlotte.Model.Facture;
import com.Orange.MaFlotte.Repo.FactureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facture")

public class FactureController {

    @Autowired
    FactureRepo factureRepo;
    @PostMapping("/add")
    public void addFacture(@RequestBody Facture facture){factureRepo.save(facture);}
}
