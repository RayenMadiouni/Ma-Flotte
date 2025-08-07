package com.Orange.MaFlotte.Model;

import org.springframework.data.annotation.Id;

public class Poste {

    @Id
    private String Id_poste;

    private TypePoste description;

    private String Id_employe;

    public Poste(TypePoste description) {
        this.description = description;
    }

    public String getId_poste() {
        return Id_poste;
    }

    public TypePoste getDescription() {
        return description;
    }

    public void setDescription(TypePoste description) {
        this.description = description;
    }

    public String getId_employe() {
        return Id_employe;
    }

    public void setId_employe(String id_employe) {
        this.Id_employe = id_employe;
    }
}
