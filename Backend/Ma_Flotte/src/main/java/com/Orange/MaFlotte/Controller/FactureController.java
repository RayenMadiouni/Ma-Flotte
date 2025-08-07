package com.Orange.MaFlotte.Controller;

import com.Orange.MaFlotte.Model.Facture;
import com.Orange.MaFlotte.Model.FactureDTO;
import com.Orange.MaFlotte.Model.Ligne;
import com.Orange.MaFlotte.Repo.EmployeRepo;
import com.Orange.MaFlotte.Repo.FactureRepo;
import com.Orange.MaFlotte.Repo.LigneRepo;
import com.Orange.MaFlotte.Service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/facture")

public class FactureController {

    @Autowired
    FactureRepo factureRepo;
    @Autowired
    EmployeRepo employeRepo;
    @Autowired
    LigneRepo ligneRepo;
    @Autowired
    FactureService factureService;
    @PostMapping("/add")
    public void addFacture(@RequestBody Facture facture){factureRepo.save(facture);}
    @GetMapping("/all")
    public List<Facture> getAllFactures() {
        return factureRepo.findAll();
    }

    @GetMapping("/dto")
    public List<FactureDTO> getAllFacturesDTO() {
        return factureService.getAllFacturesDTO();
    }

}
