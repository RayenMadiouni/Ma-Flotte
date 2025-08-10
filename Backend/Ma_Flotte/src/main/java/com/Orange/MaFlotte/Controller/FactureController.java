package com.Orange.MaFlotte.Controller;

import com.Orange.MaFlotte.Model.Facture;
import com.Orange.MaFlotte.Model.FactureDTO;
import com.Orange.MaFlotte.Model.Ligne;
import com.Orange.MaFlotte.Model.TypeLigne;
import com.Orange.MaFlotte.Repo.EmployeRepo;
import com.Orange.MaFlotte.Repo.FactureRepo;
import com.Orange.MaFlotte.Repo.LigneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facture")

public class FactureController {

    @Autowired
    FactureRepo factureRepo;
    @Autowired
    EmployeRepo employeRepo;
    @Autowired
    LigneRepo ligneRepo;


    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ajouterFacture(@RequestBody Facture facture) {
        Ligne ligneInput = facture.getLigne();

        if (ligneInput == null ||
                ligneInput.getNum() == null ||
                ligneInput.getType() == null ||
                ligneInput.getEmploye() == null ||
                ligneInput.getEmploye().getNomEmploye() == null ||
                ligneInput.getEmploye().getPrenomEmploye() == null) {

            return ResponseEntity.badRequest().body("Numéro de ligne, type et nom/prénom employé sont requis.");
        }

        Optional<Ligne> ligneExistanteOpt = ligneRepo.findByNumAndTypeAndEmploye_NomEmployeAndEmploye_PrenomEmploye(
                ligneInput.getNum(),
                ligneInput.getType(),
                ligneInput.getEmploye().getNomEmploye(),
                ligneInput.getEmploye().getPrenomEmploye()
        );

        if (ligneExistanteOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("La ligne avec ces informations n'existe pas.");
        }

        facture.setLigne(ligneExistanteOpt.get());
        Facture factureSauvegardee = factureRepo.save(facture);

        return ResponseEntity.ok(factureSauvegardee);
    }



    @GetMapping("/all")
    public List<Facture> getAllFactures() {
        return factureRepo.findAll();
    }



}
