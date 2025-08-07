package com.Orange.MaFlotte.Controller;

import com.Orange.MaFlotte.Model.Ligne;
import com.Orange.MaFlotte.Model.Employe;
import com.Orange.MaFlotte.Model.Flotteur;
import com.Orange.MaFlotte.Repo.LigneRepo;
import com.Orange.MaFlotte.Repo.EmployeRepo;
import com.Orange.MaFlotte.Repo.FlotteurRepo;
import com.Orange.MaFlotte.Service.LigneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lignes")
@CrossOrigin(origins = "*")
public class LigneController {

    @Autowired
    private LigneRepo ligneRepo;

    @Autowired
    private EmployeRepo employeRepo;

    @Autowired
    private FlotteurRepo flotteurRepo;

    @Autowired
    private LigneService ligneService;

    @PostMapping("/add")
    public ResponseEntity<?> addLigne(@RequestBody Ligne ligne) {
        String num = ligne.getNum();

        // ✅ Vérifier si le numéro est exactement 8 chiffres
        if (num == null || !num.matches("\\d{8}")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Le numéro de ligne doit contenir exactement 8 chiffres.");
        }

        // ✅ Vérifier si le numéro existe déjà
        Optional<Ligne> existingLigne = ligneRepo.findByNum(num);
        if (existingLigne.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("❌ Le numéro de ligne " + num + " existe déjà.");
        }

        // ✅ Vérifier que l'employé est présent
        Employe emp = ligne.getEmploye();
        if (emp == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ L'employé doit être renseigné.");
        }

        Optional<Employe> employeExist = Optional.empty();

        if (emp.getIdemploye() != null) {
            employeExist = employeRepo.findById(emp.getIdemploye());
        }

        if (employeExist.isPresent()) {
            ligne.setEmploye(employeExist.get());
        } else {
            // 🔄 Sauvegarde du nouvel employé
            employeRepo.save(emp);
            ligne.setEmploye(emp);
        }



        // ✅ Sauvegarde de la ligne
        ligneRepo.save(ligne);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("✅ Ligne (et employé) ajoutés avec succès.");
    }

    @GetMapping("/all")
    public List<Ligne> getAllLignes() {
        return ligneRepo.findAll();
    }

    @DeleteMapping("/del/{num}")
    public ResponseEntity<Void> deleteByNum(@PathVariable String num) {
        Optional<Ligne> ligne = ligneRepo.findByNum(num);
        if (ligne.isPresent()) {
            ligneRepo.deleteByNum(num);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
