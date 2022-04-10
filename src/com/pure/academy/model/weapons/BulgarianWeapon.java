package com.pure.academy.model.weapons;

import com.pure.academy.model.enums.Weapon;
import java.util.ArrayList;
import java.util.List;

public class BulgarianWeapon implements WeaponInterface {
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
        listOfWeapons.add(Weapon.BULGARIAN_CROSSBOW);
        listOfWeapons.add(Weapon.BULGARIAN_KNIFE);
        listOfWeapons.add(Weapon.BULGARIAN_AXE);
        return listOfWeapons;
    }
}
