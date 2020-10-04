package main.RPC;

import java.util.Random;
import java.util.Scanner;

public class Field {
    private Weapon yourWeapon;
    private Weapon programWeapon;

    public void setYourWeapon(Weapon yourWeapon) {
        this.yourWeapon = yourWeapon;
    }

    public void setProgramWeapon(Weapon programWeapon) {
        this.programWeapon = programWeapon;
    }

    public Weapon getProgramWeapon() {
        return programWeapon;
    }

    public Weapon getYourWeapon() {
        return yourWeapon;
    }
}
