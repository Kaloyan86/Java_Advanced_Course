package SetAndMaps.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class P3PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(input));
        }
        elements.forEach(e -> System.out.print(e + " "));
    }
}
