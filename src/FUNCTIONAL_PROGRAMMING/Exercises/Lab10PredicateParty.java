package FUNCTIONAL_PROGRAMMING.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab10PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        List<String> guests = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());

        while (!"Party!".equals(line = reader.readLine())) {

            String[] commandTokens = line.split("\\s+");

            String command = commandTokens[0];
            String predicateType = commandTokens[1];
            String predicateArgument = commandTokens[2];

            if (command.equals("Remove")) {
                guests.removeIf(getPredicate(predicateType, predicateArgument));
            }
            else if (command.equals("Double")) {

                for (int i = 0; i < guests.size(); i++) {
                    String guest = guests.get(i);
                    if (getPredicate(predicateType, predicateArgument).test(guest)) {
                        guests.add(i++, guest);
                    }
                }
            }
        }
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.println(String.format("%s are going to the party!", String.join(", ", guests)));
        }
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        switch (type) {
            case "StartsWith":
                return text -> text.startsWith(parameter);
            case "EndsWith":
                return text -> text.endsWith(parameter);
            case "Length":
                return text -> text.length() == Integer.parseInt(parameter);
            default:
                return text -> false;
        }
    }
}

