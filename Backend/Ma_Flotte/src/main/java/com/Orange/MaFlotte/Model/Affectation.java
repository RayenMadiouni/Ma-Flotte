package com.Orange.MaFlotte.Model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Affectation {

    @Id
    private String Id_affectation;

    private LocalDateTime date;
    private String Id_employe;

    public Affectation(LocalDateTime date) {
        this.date = date;
    }

    public String getId_affectation() {
        return Id_affectation;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
