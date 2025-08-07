package com.Orange.MaFlotte.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tache")
public class Tache {

    @Id
    private String Id_tache;

    private String action;

    private LocalDateTime dateAction;

    private TypeAction typeAction;

    private String Id_poste;
    private  String Id_entreprise;

    // ✅ Constructeurs

    public Tache() {
    }

    public Tache(String action, LocalDateTime dateAction, TypeAction typeAction, String cible, Employe acteur, String posteActeur) {
        this.action = action;
        this.dateAction = dateAction;
        this.typeAction = typeAction;


    }

    // ✅ Getters & Setters

    public String getId() {
        return Id_tache;
    }

    public void setId(String id) {
        this.Id_tache = Id_tache;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getDateAction() {
        return dateAction;
    }

    public void setDateAction(LocalDateTime dateAction) {
        this.dateAction = dateAction;
    }

    public TypeAction getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }












}
