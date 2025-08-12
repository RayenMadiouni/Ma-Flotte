package com.Orange.MaFlotte.Controller;

import com.Orange.MaFlotte.DTO.RechargeRequest;
import com.Orange.MaFlotte.Model.Ligne;
import com.Orange.MaFlotte.Model.Employe;
import com.Orange.MaFlotte.Model.User;
import com.Orange.MaFlotte.Repo.LigneRepo;
import com.Orange.MaFlotte.Repo.EmployeRepo;
import com.Orange.MaFlotte.Repo.FlotteurRepo;
import com.Orange.MaFlotte.Repo.UserRepo;
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
    private UserRepo userRepo; // ✅ Nouveau

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

        // ✅ Vérifier que le UserNum existe
        String UserNum = ligne.getUserNum();
        if (UserNum == null || UserNum.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Le UserNum est obligatoire.");
        }

        Optional<User> userExist = userRepo.findByUserNum(UserNum);
        if (userExist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("❌ Aucun utilisateur trouvé avec UserNum : " + UserNum);
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
            employeRepo.save(emp);
            ligne.setEmploye(emp);
        }

        // ✅ Sauvegarde de la ligne
        ligneRepo.save(ligne);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("✅ Ligne ajoutée avec succès pour l'utilisateur " + UserNum);
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

    @PostMapping("/charger/{num}")
    public ResponseEntity<?> chargerLigne(@PathVariable String num, @RequestBody RechargeRequest rechargeRequest) {
        return ligneRepo.findByNum(num)
                .map(ligne -> {
                    ligne.setAppelsMinutes(ligne.getAppelsMinutes() + rechargeRequest.getAppelsMinutes());
                    ligne.setNombreSMS(ligne.getNombreSMS() + rechargeRequest.getNombreSMS());
                    ligne.setDataGo(ligne.getDataGo() + rechargeRequest.getDataGo());
                    ligneRepo.save(ligne);
                    return ResponseEntity.ok("Recharge effectuée pour la ligne " + num);
                })
                .orElseGet(() -> ResponseEntity.status(404).body("Ligne non trouvée : " + num));
    }

}
