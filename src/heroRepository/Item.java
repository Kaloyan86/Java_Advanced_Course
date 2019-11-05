package heroRepository;

public class Item {
    private int strength;
    private int agility;
    private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }
    @Override
    public String toString(){
        return String.format("Item:\n  *  Strength: %d\n  *  Agility: %d\n  *  Intelligence: %d",
                getStrength(),getAgility(),getIntelligence());
    }
}
