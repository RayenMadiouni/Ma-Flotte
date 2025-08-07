package com.Orange.MaFlotte.Model;

import java.time.LocalDateTime;

public class FactureDTO {
    private String id_facture;
    private float montant;
    private EtatFacture etat;
    private LocalDateTime datePaiement;
    private String num;
    private String nomEmploye;



    public FactureDTO(String num, float montant, EtatFacture etat, LocalDateTime datePaiement, String nomEmploye) {
        this.num = num;
        this.montant = montant;
        this.etat = etat;
        this.datePaiement = datePaiement;
        this.nomEmploye = nomEmploye;
    }


    // Getters et Setters
    public String getId_facture() { return id_facture; }
    public void setId_facture(String id_facture) { this.id_facture = id_facture; }

    public float getMontant() { return montant; }
    public void setMontant(float montant) { this.montant = montant; }

    public EtatFacture getEtat() { return etat; }
    public void setEtat(EtatFacture etat) { this.etat = etat; }

    public LocalDateTime getDatePaiement() { return datePaiement; }
    public void setDatePaiement(LocalDateTime datePaiement) { this.datePaiement = datePaiement; }

    public String getNum() { return num; }
    public void setNum(String num) { this.num = num; }

    public String getNomEmploye() { return nomEmploye; }
    public void setNomEmploye(String nomEmploye) { this.nomEmploye = nomEmploye; }
}

