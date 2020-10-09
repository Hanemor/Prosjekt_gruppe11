package com.testresultater.alletestresultater;

public class alleresultatParameter {
    private int år;
    private  int uke;
    private String klasse;

    public alleresultatParameter(int år, int uke, String klasse) {
        this.år = år;
        this.uke = uke;
        this.klasse = klasse;
    }


    public int getÅr() {
        return år;
    }

    public void setÅr(int år) {
        this.år = år;
    }

    public int getUke() {
        return uke;
    }

    public void setUke(int uke) {
        this.uke = uke;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
}
