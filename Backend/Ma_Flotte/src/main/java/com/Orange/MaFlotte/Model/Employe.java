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
    private  String idemploye;
    private  String nom_employe;
    private String prenom_employe;
    private String Id_entreprise;

    public Employe(String nom_employe, String prenom_employe, String Id_entreprise) {
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
        this.Id_entreprise = Id_entreprise;
    }

    public String getIdemploye() {
        return idemploye;
    }

    public String getNom_employe() {
        return nom_employe;
    }

    public String getPrenom_employe() {
        return prenom_employe;
    }

    public String getId_entreprise() {
        return Id_entreprise;
    }
}
