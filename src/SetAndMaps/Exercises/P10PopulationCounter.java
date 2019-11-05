package SetAndMaps.Exercises;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Long>> infoData = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Integer.parseInt(data[2]);

            infoData.putIfAbsent(country, new LinkedHashMap<>());
            infoData.get(country).put(city, population);


            input = scanner.nextLine();
        }
        infoData.entrySet().stream().sorted((e1, e2) -> {
            Long first = infoData.get(e1.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            Long second = infoData.get(e2.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();

            return second.compareTo(first);
        }).forEach(entry -> {
            System.out.println(String.format("%s (total population: %d)", entry.getKey(), entry.getValue()
                    .values()
                    .stream()
                    .mapToLong(e -> e).sum()));
            entry.getValue().entrySet().stream().sorted((e1, e2) ->
                    e2.getValue().compareTo(e1.getValue())).forEach(p -> {
                        System.out.println(String.format("=>%s: %d", p.getKey(), p.getValue()));
                    }

            );

        });
    }
}
