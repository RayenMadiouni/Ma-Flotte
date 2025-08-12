package com.Orange.MaFlotte.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "lignes") // ✅ important

public class Ligne {
    @Id
    private String Id_ligne;

    private String num;
    private TypeLigne type;
    private Statut statut;
    private int appelsMinutes;
    private int nombreSMS;
    private double dataGo;
    private Employe employe;
    private String UserNum;




    public Ligne( String num, TypeLigne type, Statut statut,  int appelsMinutes, int nombreSMS, double dataGo, Employe employe, String UserNum ) {

        this.num = num;
        this.type = type;
        this.statut = statut;

        this.appelsMinutes = appelsMinutes;
        this.nombreSMS = nombreSMS;
        this.dataGo = dataGo;
        this.employe = employe;
        this.UserNum = UserNum;
    }
  public Ligne(String num, TypeLigne type,Employe employe){
        this.num = num;
        this.type = type;
        this.employe = employe;
  }

    public String getId_ligne() {
        return Id_ligne;
    }

    public void setId_ligne(String id_ligne) {
        Id_ligne = id_ligne;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public TypeLigne getType() {
        return type;
    }

    public void setType(TypeLigne type) {
        this.type = type;
    }

    public Statut getStatut() {
        return statut;
    }

    public Employe getEmploye() {
        return employe;
    }



    public void setStatut(Statut statut) {
        this.statut = statut;
    }


    public String getUserNum() {
        return UserNum;
    }

    public void setUserNum(String userNum) {
        UserNum = userNum;
    }

    public int getAppelsMinutes() {
        return appelsMinutes;
    }

    public void setAppelsMinutes(int appelsMinutes) {
        this.appelsMinutes = appelsMinutes;
    }

    public int getNombreSMS() {
        return nombreSMS;
    }

    public void setNombreSMS(int nombreSMS) {
        this.nombreSMS = nombreSMS;
    }

    public double getDataGo() {
        return dataGo;
    }

    public void setDataGo(double dataGo) {
        this.dataGo = dataGo;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }


}
