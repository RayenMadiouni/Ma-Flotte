package com.Orange.MaFlotte.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "factures")
public class Facture {


    @Id
    private String Id_facture;
    private String num;
    private float montant;
    private EtatFacture etat;
    private LocalDateTime datePaiement;
    private String Id_ligne;

    public Facture() {
        // Constructeur vide obligatoire pour JPA
    }

    public Facture(String num, float montant, EtatFacture etat, LocalDateTime date,String Id_ligne) {
        this.num=num;
        this.montant = montant;
        this.etat = etat;
        this.datePaiement = date;
        this.Id_ligne = Id_ligne;
    }

    // Getters & setters
    public String getId_facture() {
        return Id_facture;
    }

    public void setId_facture(String id_facture) {
        this.Id_facture = id_facture;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public EtatFacture getEtat() {
        return etat;
    }

    public void setEtat(EtatFacture etat) {
        this.etat = etat;
    }



    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getId_ligne() {
        return Id_ligne;
    }

    public void setId_ligne(String Id_ligne) {
        this.Id_ligne = Id_ligne;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
