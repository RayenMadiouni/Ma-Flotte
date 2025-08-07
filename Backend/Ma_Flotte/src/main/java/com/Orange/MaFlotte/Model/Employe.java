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
    private  String Idemploye;
    private  String nom_employe;
    private String prenom_employe;
    private int Id_entreprise;

    public Employe(String nom_employe, String prenom_employe) {
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
    }

    public String getIdemploye() {
        return Idemploye;
    }

    public String getNom_employe() {
        return nom_employe;
    }

    public String getPrenom_employe() {
        return prenom_employe;
    }

    public int getId_entreprise() {
        return Id_entreprise;
    }
}
