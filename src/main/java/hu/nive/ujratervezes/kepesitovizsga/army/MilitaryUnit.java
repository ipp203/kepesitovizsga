package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
    private int hitPoints;
    private final int damage;
    private final boolean armor;

    protected MilitaryUnit(int hitPoints, int damage, boolean armor) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.armor = armor;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    protected void decHitPoints(int damage) {
        hitPoints -= armor?damage/2:damage;
    }

    public abstract int doDamage();

    public abstract void sufferDamage(int damage);
}
