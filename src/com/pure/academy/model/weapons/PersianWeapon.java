package com.pure.academy.model.weapons;

import com.pure.academy.model.enums.Weapon;
import java.util.ArrayList;
import java.util.List;

public class PersianWeapon implements WeaponInterface {
    Weapon weapon = Weapon.FIST;

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
        listOfWeapons.add(Weapon.PERSIAN_CROSSBOW);
        listOfWeapons.add(Weapon.PERSIAN_KNIFE);
        listOfWeapons.add(Weapon.PERSIAN_AXE);
        return listOfWeapons;
    }
}
