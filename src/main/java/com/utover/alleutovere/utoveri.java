package com.utover.alleutovere;

public class utoveri {
    private int uID;
    private int kjonnID;
    private int klubbID;
    private int KlasseID;
    private String fornavn;
    private String etternavn;
    private int fodt;

    public utoveri(int uID, int kjonnID, int klubbID, int klasseID, String fornavn, String etternavn, int fodt) {
        this.uID = uID;
        this.kjonnID = kjonnID;
        this.klubbID = klubbID;
        KlasseID = klasseID;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodt = fodt;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public int getKjonnID() {
        return kjonnID;
    }

    public void setKjonnID(int kjonnID) {
        this.kjonnID = kjonnID;
    }

    public int getKlubbID() {
        return klubbID;
    }

    public void setKlubbID(int klubbID) {
        this.klubbID = klubbID;
    }

    public int getKlasseID() {
        return KlasseID;
    }

    public void setKlasseID(int klasseID) {
        KlasseID = klasseID;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public int getFodt() {
        return fodt;
    }

    public void setFodt(int fodt) {
        this.fodt = fodt;
    }
}
