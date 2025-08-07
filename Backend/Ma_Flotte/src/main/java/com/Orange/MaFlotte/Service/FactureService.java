package com.Orange.MaFlotte.Service;

import com.Orange.MaFlotte.Model.*;
import com.Orange.MaFlotte.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FactureService {

    @Autowired
    private FactureRepo factureRepo;

    @Autowired
    private LigneRepo ligneRepo;

    public List<FactureDTO> getAllFacturesDTO() {
        List<Facture> factures = factureRepo.findAll();
        List<FactureDTO> dtoList = new ArrayList<>();

        for (Facture f : factures) {


            FactureDTO dto = new FactureDTO(
                    dto.getNum(),
                    dto.getMontant(),
                    dto.getEtat(),
                    dto.getDatePaiement(),
                    nomEmploye
            );
            dto.setId_facture(f.getId_facture());
            dto.setMontant(f.getMontant());
            dto.setEtat(f.getEtat());
            dto.setDatePaiement(f.getDatePaiement());

            // ➕ Récupérer la ligne associée
            Optional<Ligne> ligneOpt = ligneRepo.findById(f.getId_ligne());
            if (ligneOpt.isPresent()) {
                Ligne ligne = ligneOpt.get();
                dto.setNum(ligne.getNum());

                // ➕ Récupérer le nom de l'employé
                Employe emp = ligne.getEmploye();
                if (emp != null) {
                    String nomComplet = emp.getPrenom_employe() + " " + emp.getNom_employe();
                    dto.setNomEmploye(nomComplet);
                } else {
                    dto.setNomEmploye("Inconnu");
                }
            } else {
                dto.setNum(null);
                dto.setNomEmploye("Inconnu");
            }

            dtoList.add(dto);
        }

        return dtoList;
    }

}
