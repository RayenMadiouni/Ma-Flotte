package com.Orange.MaFlotte.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor

public class Employe {
    @Id
    private String idemploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String Id_entreprise;

    public Employe(String nom_employe, String prenom_employe, String Id_entreprise) {
        this.nomEmploye = nom_employe;
        this.prenomEmploye = prenom_employe;
        this.Id_entreprise = Id_entreprise;
    }

    public String getIdemploye() {
        return idemploye;
    }

    public String getNom_employe() {
        return nomEmploye;
    }

    public String getPrenom_employe() {
        return prenomEmploye;
    }

    public String getId_entreprise() {
        return Id_entreprise;
    }
}
