package com.pure.academy.model;

public enum Weapon {
    FIST(0), KNIFE(100), SWORD(500), CROSSBOW(1000);

    public final int price;
    private Weapon(int price) {
        this.price = price;
    }
}