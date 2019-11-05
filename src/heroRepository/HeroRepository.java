package heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public List<Hero> getData() {
        return data;
    }


    public void add(Hero entity) {
        getData().add(entity);
    }

    public void remove(String name) {
        getData().removeIf(e -> e.getName().equals(name));
    }

    public Hero getHeroWithHighestStrength() {
        Hero hero = getData().stream()
                .min((e1, e2) -> Integer.compare(e2.getItem().getStrength(), e1.getItem().getStrength())).get();
        return hero;
    }

    public Hero getHeroWithHighestAgility() {
        Hero hero = getData().stream()
                .min((e1, e2) -> Integer.compare(e2.getItem().getAgility(), e1.getItem().getAgility())).get();
        return hero;
    }

    public Hero getHeroWithHighestIntelligence() {
        Hero hero = getData().stream()
                .min((e1, e2) -> Integer.compare(e2.getItem().getIntelligence(), e1.getItem().getIntelligence())).get();
        return hero;
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            stringBuilder.append(data.get(i)).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
