package arena;

import java.util.ArrayList;
import java.util.List;

public class FightingArena {
    private List<Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new ArrayList<>();
    }

    public void add(Gladiator entity) {
        gladiators.add(entity);
    }

    public List<Gladiator> getGladiators() {
        return gladiators;
    }

    public String getName() {
        return name;
    }

    public void remove(String name) {
        gladiators.removeIf(e -> e.getName().equals(name));
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        return gladiators.stream().min((e1, e2) -> Integer.compare(e2.getStatPower(), e1.getStatPower())).get();
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        return gladiators.stream().min((e1, e2) -> Integer.compare(e2.getWeaponPower(), e1.getWeaponPower())).get();
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        return gladiators.stream().min((e1, e2) -> Integer.compare(e2.getTotalPower(), e1.getTotalPower())).get();
    }

    public int getCount() {
        return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s – %d gladiators are participating.", this.getName(), this.getCount());
    }
}
