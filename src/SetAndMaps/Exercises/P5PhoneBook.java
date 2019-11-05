package SetAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P5PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {

            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];

            phoneBook.putIfAbsent(name, number);
            phoneBook.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {

            String finalInput = input;

            if (phoneBook.containsKey(finalInput)) {
                System.out.println(String.format("%s -> %s", finalInput, phoneBook.get(finalInput)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", finalInput));
            }


            input = scanner.nextLine();
        }

    }
}
