package DEFINING_CLASSES.Exercises.Ex1OpinionPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> allPersons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");

            Person person = new Person(data[0], Integer.parseInt(data[1]));

            allPersons.add(person);
        }
        allPersons
                .stream()
                .filter(e -> e.age > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);

    }
}
