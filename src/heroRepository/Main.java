package heroRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Item item = new Item(2, 2, 2);
        Hero hero = new Hero("asd", 2, item);
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.add(hero);
        heroRepository.remove(hero.getName());
        heroRepository.getCount();

    }
}
