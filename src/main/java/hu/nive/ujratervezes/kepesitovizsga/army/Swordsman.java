package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    private boolean shield;

    public Swordsman(boolean armor) {
        super(100, 10, armor);
        shield = true;
    }

    @Override
    public int doDamage() {
        return getDamage();
    }

    @Override
    public void sufferDamage(int damage) {
        if (!shield) {
            decHitPoints(damage);
        }
        shield = false;
    }
}
