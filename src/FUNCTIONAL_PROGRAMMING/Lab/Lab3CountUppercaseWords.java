package FUNCTIONAL_PROGRAMMING.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab3CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> iSstartingWithCapital = word -> Character.isUpperCase(word.charAt(0));

        List<String> capitalWords = Arrays.stream(words)
                .filter(iSstartingWithCapital).collect(Collectors.toList());

        System.out.println(capitalWords.size());

        capitalWords.forEach(System.out::println);

    }
}
