package com.Orange.MaFlotte.DTO;

import com.Orange.MaFlotte.Model.Employe;
import com.Orange.MaFlotte.Model.Statut;
import com.Orange.MaFlotte.Model.TypeLigne;

public class LigneAvecEmployeDTO {

    private String id_ligne;
    private String num;
    private TypeLigne type;
    private Statut statut;
    private int appelsMinutes;
    private int nombreSMS;
    private double dataGo;

    private Employe employe; // Employé lié à cette ligne

    // Constructeurs, Getters, Setters

    public LigneAvecEmployeDTO(String id_ligne,String num,TypeLigne type,Statut statut,int appelsMinutes,int nombreSMS,double dataGo) {
        this.id_ligne = id_ligne;
        this.num = num;
        this.type = type;
        this.statut = statut;
        this.appelsMinutes = appelsMinutes;
        this.nombreSMS = nombreSMS;
        this.dataGo = dataGo;
    }

    public String getId_ligne() {
        return id_ligne;
    }

    public String getNum() {
        return num;
    }

    public TypeLigne getType() {
        return type;
    }

    public Statut getStatut() {
        return statut;
    }

    public int getAppelsMinutes() {
        return appelsMinutes;
    }

    public int getNombreSMS() {
        return nombreSMS;
    }

    public double getDataGo() {
        return dataGo;
    }

    public Employe getEmploye() {
        return employe;
    }
}

