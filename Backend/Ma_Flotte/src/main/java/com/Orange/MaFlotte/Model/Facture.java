package com.Orange.MaFlotte.Model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Facture {
    @Id
    private String Id_facture;
    private float montant;
    private String etat;
    private boolean paye;
    private LocalDateTime datePaiement;
    private String Id_ligne;

    public Facture(float montant, String etat) {
        this.montant = montant;
        this.etat = etat;
    }

    public String getId_facture() {
        return Id_facture;
    }

    public float getMontant() {
        return montant;
    }

    public String getEtat() {
        return etat;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
