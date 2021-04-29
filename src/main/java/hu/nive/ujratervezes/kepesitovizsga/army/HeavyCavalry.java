package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {
    private boolean firstAttack;

    public HeavyCavalry() {
        super(150, 20, true);
        firstAttack = true;
    }

    @Override
    public int doDamage() {
        if (firstAttack) {
            firstAttack = false;
            return 3 * getDamage();
        } else {
            return getDamage();
        }
    }

    @Override
    public void sufferDamage(int damage) {
        decHitPoints(damage);
    }
}

