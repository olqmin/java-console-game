package com.pure.academy.model.enums;

public enum Weapon {

    FIST("fist", 0, 0, 2),

    SCANDINAVIAN_KNIFE("knife", 100, 2, 7),
    SCANDINAVIAN_AXE("axe", 500, 7, 12),
    SCANDINAVIAN_CROSSBOW("crossbow", 1000, 12, 20),

    OTTOMAN_KNIFE("knife", 1000, 12, 20),
    OTTOMAN_AXE("axe", 100, 2, 7),
    OTTOMAN_CROSSBOW("crossbow", 500, 7, 12),

    PERSIAN_KNIFE("knife", 500, 7, 12),
    PERSIAN_AXE("axe", 1000, 12, 20),
    PERSIAN_CROSSBOW("crossbow", 100, 2, 7),

    BULGARIAN_KNIFE("knife", 500, 7, 12),
    BULGARIAN_AXE("axe", 1000, 12, 20),
    BULGARIAN_CROSSBOW("crossbow", 100, 2, 7);

    public final String name;
    public final int price;
    public final int minDamage;
    public final int maxDamage;

    Weapon(String name, int price, int minDamage, int maxDamage) {
        this.name = name;
        this.price = price;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
}
