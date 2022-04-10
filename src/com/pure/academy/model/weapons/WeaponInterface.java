package com.pure.academy.model.weapons;

import com.pure.academy.model.enums.Weapon;
import java.util.List;

public interface WeaponInterface {
    Weapon getCurrentWeapon();
    void setCurrentWeapon(Weapon weapon);
    List<Weapon> getPurchasableWeapons();
}
