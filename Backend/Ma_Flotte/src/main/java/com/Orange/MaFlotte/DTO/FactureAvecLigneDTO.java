package com.Orange.MaFlotte.DTO;

import com.Orange.MaFlotte.Model.*;

import java.time.LocalDateTime;

public class FactureAvecLigneDTO {

    private String Id_facture;

    private float montant;
    private EtatFacture etat;
    private LocalDateTime datePaiement;

    private Ligne ligne;

    // Constructeurs, Getters, Setters

    public FactureAvecLigneDTO(String Id_facture,float montant,EtatFacture etat,LocalDateTime datePaiement) {
        this.Id_facture = Id_facture;
        this.montant = montant;
        this.etat = etat;
        this.datePaiement = datePaiement;

    }

    public String getId_facture() {
        return Id_facture;
    }

    public float getNum() {
        return montant;
    }

    public EtatFacture getType() {
        return etat;
    }

    public LocalDateTime getStatut() {
        return datePaiement;
    }

    public float getMontant() {
        return montant;
    }

    public EtatFacture getEtat() {
        return etat;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public Ligne getLigne() {
        return ligne;
    }
}

