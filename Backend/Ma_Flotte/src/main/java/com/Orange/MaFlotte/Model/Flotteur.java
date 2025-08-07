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

public class Flotteur {


    @Id
    private String Id_flotteur;
    private String num;
    private int CIN;
    private String nom_flotteur;
    private String prenom_flotteur;

    public Flotteur(String nom_flotteur,String prenom_flotteur) {
        this.nom_flotteur = nom_flotteur;
        this.prenom_flotteur = prenom_flotteur;
    }


    public String getId_flotteur() {
        return Id_flotteur;
    }

    public String getnum() {
        return num;
    }

    public int getCIN() {
        return CIN;
    }

    public String getNom_flotteur() {
        return nom_flotteur;
    }

    public String getPrenom_flotteur() {
        return prenom_flotteur;
    }

    public void setNom_flotteur(String nom_flotteur) {
        this.nom_flotteur = nom_flotteur;
    }

    public void setPrenom_flotteur(String prenom_flotteur) {
        this.prenom_flotteur = prenom_flotteur;
    }
}

