package SetAndMaps.Exercises;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P11LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        Map<String, Integer> logsDurations = new LinkedHashMap<>();
        Map<String, ArrayList<String>> logsIP = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] data = input.split("\\s+");
            String ip = data[0];
            String name = data[1];
            int duration = Integer.parseInt(data[2]);

            logsDurations.putIfAbsent(name, 0);
            logsDurations.put(name, logsDurations.get(name) + duration);

            logsIP.putIfAbsent(name, new ArrayList<>());
            if (!logsIP.get(name).contains(ip)) {
                logsIP.get(name).add(ip);
            }

            input = scanner.nextLine();
        }
        logsDurations.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e -> {
                    System.out.print(e.getKey() + ": " + e.getValue() + " [");
                    System.out.print(String.join(", ", logsIP.get(e.getKey()).stream()
                            .sorted(String::compareTo)
                            .collect(Collectors.toList())));
                    System.out.print("]");
                    System.out.println();
                });
    }
}
