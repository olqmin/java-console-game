package com.pure.academy.model;

public class KingdomModel {

    private final String kingName;
    private final String princessName;
    private final String monsterName;
    private final String mountainName;
    private final String riverName;
    private final String kingdomName;
    private String monsterDesc;

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

    public String getPrincessName() {
        return princessName;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public String getMountainName() {
        return mountainName;
    }

    public String getRiverName() {
        return riverName;
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

    public void setMonsterDesc(String monsterDesc) {
        this.monsterDesc = monsterDesc;
    }

}
