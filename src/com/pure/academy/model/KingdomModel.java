package com.pure.academy.model;

public class KingdomModel {

    private String kingName;
    private String princessName;
    private String monsterName;
    private String mountainName;
    private String riverName;
    private String kingdomName;
    

    public KingdomModel(String kingName, String princessName, String monsterName, String mountainName, String riverName, String kingdomName) {
        this.kingName = kingName;
        this.princessName = princessName;
        this.monsterName = monsterName;
        this.mountainName = mountainName;
        this.riverName = riverName;
        this.kingdomName = kingdomName;
    }

    public String getKingName() {
        return kingName;
    }

    public void setKingName(String kingName) {
        this.kingName = kingName;
    }

    public String getPrincessName() {
        return princessName;
    }

    public void setPrincesName(String princesName) {
        this.princessName = princesName;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMountainName() {
        return mountainName;
    }

    public void setMountainName(String mountainName) {
        this.mountainName = mountainName;
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public void setKingdomName(String kingdomName) {
        this.kingdomName = kingdomName;
    }
}
