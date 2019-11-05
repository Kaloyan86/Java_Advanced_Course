package SetAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P2SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashSet<String> firstNumbers = new LinkedHashSet<>();
        LinkedHashSet<String> secondNumbers = new LinkedHashSet<>();

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String number = "";
        for (int i = 0; i < n; i++) {
            number = scanner.nextLine();
            firstNumbers.add(number);
        }
        for (int i = 0; i < m; i++) {
            number = scanner.nextLine();
            secondNumbers.add(number);
        }
        firstNumbers.retainAll(secondNumbers);
        firstNumbers.forEach(e -> System.out.print(e + " "));
    }
}
