package SetAndMaps.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P8HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> hands = new LinkedHashMap<>();
        Map<String, Integer> score = new LinkedHashMap<>();

        String line;
        while (!"JOKER".equals(line=scanner.nextLine()))
        {
            String name = line.split(":")[0];
            List<String> cardsList = Arrays.stream(line.split(":")[1].trim().split(", ")).collect(Collectors.toList());

            hands.putIfAbsent(name, new LinkedList<>());
            for (String newCard:
                    cardsList) {
                if (!hands.get(name).contains(newCard)){
                    hands.get(name).add(newCard);
                }
            }

            for (Map.Entry<String, List<String>> entry:
                    hands.entrySet()) {
                Integer playerScore = 0;
                for (String card:
                        entry.getValue()) {
                    String power = card.split("")[0];
                    Integer powerInt = 0;
                    String type = card.split("")[1];
                    Integer typeInt = 0;
                    Integer cardScore = 0;
                    if (power.equals("J")){
                        powerInt = 11;
                    } else if (power.equals("Q")){
                        powerInt = 12;
                    } else if (power.equals("K")) {
                        powerInt = 13;
                    } else if (power.equals("A")){
                        powerInt = 14;
                    } else {
                        powerInt = Integer.parseInt(power);
                    }

                    if (type.equals("S")){
                        typeInt = 4;
                    } else if (type.equals("H")){
                        typeInt = 3;
                    } else if (type.equals("D")){
                        typeInt = 2;
                    } else if (type.equals("C")){
                        typeInt = 1;
                    }

                    cardScore = powerInt * typeInt;
                    playerScore += cardScore;
                }

                score.putIfAbsent(entry.getKey(), 0);
                score.replace(entry.getKey(), playerScore);
            }
        }

        for (Map.Entry<String, Integer> entry:
                score.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
