package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Army {
    private List<MilitaryUnit> horde;

    public Army() {
        horde = new ArrayList<>();
    }

    public void addUnit(MilitaryUnit militaryUnit) {
        horde.add(militaryUnit);
    }

    public void damageAll(int damage) {
        horde.forEach(mu -> mu.sufferDamage(damage));
        horde = horde.stream()
                .filter(mu -> mu.getHitPoints() >= 25)
                .collect(Collectors.toList());
    }

    public int getArmyDamage() {
        return horde.stream()
                .mapToInt(MilitaryUnit::doDamage)
                .sum();
    }

    public int getArmySize() {
        return horde.size();
    }
}
