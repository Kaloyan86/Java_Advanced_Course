package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage{
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        boolean contains = false;
        for (int i = 0; i < this.data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                contains = true;
                this.data.remove(i);
                break;
            }
        }
        return contains;
    }


    public void removeSpecies(String species) {
        this.data = this.data.stream().filter(e -> e.getSpecies().equals(species)).collect(Collectors.toList());
    }

    public Rabbit sellRabbit(String name){
        for (Rabbit rabbits : this.data) {
            if(rabbits.getName().equals(name)){
                rabbits.setAvailable(false);
                return rabbits;
            }

        }
        return null;
    }
    public List<Rabbit>sellRabbitBySpecies(String species){
        List<Rabbit>rabs=this.data.stream().filter(e->e.getSpecies().equals(species)).collect(Collectors.toList());
        for (Rabbit rab : rabs) {
            rab.setAvailable(false);
        }
        return rabs;
    }
    public int count(){
        return this.data.size();
    }
    public String report(){
        StringBuilder sb=new StringBuilder();

        sb.append((String.format("Rabbits available at %s:",this.name)))
                .append(System.lineSeparator());
        this.data.stream().filter(Rabbit::isAvailable).forEach(sb::append);
        return sb.toString().trim();
    }
}
