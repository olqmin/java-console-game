package com.pure.academy.model.weapons;

import com.pure.academy.model.enums.Weapon;

import java.util.ArrayList;
import java.util.List;

public class OttomanWeapon implements WeaponInterface {
    Weapon weapon = Weapon.FIST;
    Weapon ultimateWeapon = Weapon.OTTOMAN_KNIFE;

    @Override
    public Weapon getCurrentWeapon() {
        return weapon;
    }

    @Override
    public void setCurrentWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public List<Weapon> getPurchasableWeapons() {
        List<Weapon> listOfWeapons = new ArrayList<>();
        listOfWeapons.add(Weapon.OTTOMAN_AXE);
        listOfWeapons.add(Weapon.OTTOMAN_CROSSBOW);
        listOfWeapons.add(Weapon.OTTOMAN_KNIFE);
        return listOfWeapons;
    }
}
