package SetAndMaps.Exercises;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P1ProblemUniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> uniqueUserNames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            uniqueUserNames.add(scanner.nextLine());
        }
        uniqueUserNames.forEach(System.out::println);
    }
}
