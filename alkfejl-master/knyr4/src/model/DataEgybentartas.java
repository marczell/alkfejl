/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marcell
 */
public class DataEgybentartas {
    
    private String nev;
    private String ertek;

    public DataEgybentartas(String nev, String ertek) {
        this.nev = nev;
        this.ertek = ertek;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getErtek() {
        return ertek;
    }

    public void setErtek(String ertek) {
        this.ertek = ertek;
    }

    
    
}
