package SetAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P7FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();
        String name = scanner.nextLine();


        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emails.putIfAbsent(name, email);
            }

            name = scanner.nextLine();

        }
        emails.forEach((k, v) -> System.out.println(String.format("%s -> %s", k, v)));
    }
}
