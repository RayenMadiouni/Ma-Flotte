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

public class Entreprise {
    @Id
    private String Id_entreprise;
    private String nom_entreprise;
    private String Id_flotteur;

    public Entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getId_entreprise() {
        return Id_entreprise;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public String getId_flotteur() {
        return Id_flotteur;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }
}
