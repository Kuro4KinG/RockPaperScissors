package main.RPC;

public enum Weapon {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private String weapon;

    Weapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeapon() {
        return weapon;
    }
}
