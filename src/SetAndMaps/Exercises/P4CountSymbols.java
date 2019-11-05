package SetAndMaps.Exercises;

import java.util.Scanner;
import java.util.TreeMap;

public class P4CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<Character, Integer> countSymbols = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            countSymbols.putIfAbsent(text.charAt(i), 0);
            countSymbols.put(text.charAt(i), countSymbols.get(text.charAt(i)) + 1);
        }
        countSymbols.forEach((k, v) ->
                System.out.println(String.format("%s: %d time/s", k, v)));
    }
}
