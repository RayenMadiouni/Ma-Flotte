package com.Orange.MaFlotte.DTO;


import lombok.Data;

@Data
public class RechargeRequest {
    private int appelsMinutes;
    private int nombreSMS;
    private double dataGo;

    // Getters & Setters
    public int getAppelsMinutes() { return appelsMinutes; }
    public void setAppelsMinutes(int appelsMinutes) { this.appelsMinutes = appelsMinutes; }

    public int getNombreSMS() { return nombreSMS; }
    public void setNombreSMS(int nombreSMS) { this.nombreSMS = nombreSMS; }

    public double getDataGo() { return dataGo; }
    public void setDataGo(double dataGo) { this.dataGo = dataGo; }

}
