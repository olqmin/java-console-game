package com.pure.academy.util;

import com.pure.academy.model.Weapon;

public class GameDataHelper {
    private int playerHP;
    private String playerName;
    private int choice;
    private int monsterHP;
    private boolean quizKey;
    private boolean caveKey;
    private int playerMoney;
    private int numberOfRabbits;
    private int numberOfTrees;
    private Weapon playerWeapon = Weapon.FIST;
    private int playerDamage;
    private int medicine;

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    public boolean isQuizKey() {
        return quizKey;
    }

    public void setQuizKey(boolean quizKey) {
        this.quizKey = quizKey;
    }

    public boolean isCaveKey() {
        return caveKey;
    }

    public void setCaveKey(boolean caveKey) {
        this.caveKey = caveKey;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public int getNumberOfRabbits() {
        return numberOfRabbits;
    }

    public void setNumberOfRabbits(int numberOfRabbits) {
        this.numberOfRabbits = numberOfRabbits;
    }

    public int getNumberOfTrees() {
        return numberOfTrees;
    }

    public void setNumberOfTrees(int numberOfTrees) {
        this.numberOfTrees = numberOfTrees;
    }

    public Weapon getPlayerWeapon() {
        return playerWeapon;
    }

    public void setPlayerWeapon(Weapon playerWeapon) {
        this.playerWeapon = playerWeapon;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }

    public void setPlayerDamage(int playerDamage) {
        this.playerDamage = playerDamage;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }
}
