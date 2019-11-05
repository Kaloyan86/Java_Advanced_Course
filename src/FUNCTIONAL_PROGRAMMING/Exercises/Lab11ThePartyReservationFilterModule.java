package FUNCTIONAL_PROGRAMMING.Exercises;

import java.util.*;
import java.util.function.Predicate;

public class Lab11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> names = new LinkedList<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(nm -> names.add(nm));
        LinkedList<String> firstInput=(LinkedList<String>) names.clone();
        LinkedList<String> startsWith= new LinkedList<>();
        LinkedList<String> endsWith= new LinkedList<>();
        LinkedList<String> containsWith= new LinkedList<>();
        LinkedList<String> lenghtWith= new LinkedList<>();
        String cmd = sc.nextLine();
        while (!cmd.equals("Print")) {
            String[] parts = cmd.split(";");
            switch (parts[0]) {
                case "Add filter":
                    switch (parts[1]){
                        case"Starts with":
                            String startsWithSubString=parts[2];
                            names.stream().filter(AddFilterStartsWith(startsWithSubString)).forEach(left->startsWith.add(left));
                            names.removeAll(startsWith);
                            break;
                        case"Ends with":
                            String endsWithSubString=parts[2];
                            names.stream().filter(AddFilterEndsWith(endsWithSubString)).forEach(left->endsWith.add(left));
                            names.removeAll(endsWith);
                            break;
                        case"Contains":
                            String contains=parts[2];
                            names.stream().filter(AddFilterContains(contains)).forEach(left->containsWith.add(left));
                            names.removeAll(containsWith);
                            break;
                        case"Length":
                            Integer lenght = Integer.parseInt(parts[2]);
                            names.stream().filter(AddFilterLenght(lenght)).forEach(left->lenghtWith.add(left));
                            names.removeAll(lenghtWith);
                            break;
                    }
                    break;
                case "Remove filter":
                    switch (parts[1]){
                        case"Starts with":
                            String startsWithSubString=parts[2];
                            startsWith.stream().filter(AddFilterStartsWith(startsWithSubString)).forEach(reversed->names.add(reversed));
                            startsWith.removeAll(names);
                            break;
                        case"Ends with":
                            String endsWithSubString=parts[2];
                            endsWith.stream().filter(AddFilterEndsWith(endsWithSubString)).forEach(left->names.add(left));
                            endsWith.removeAll(names);
                            break;
                        case"Contains":
                            String contains=parts[2];
                            containsWith.stream().filter(AddFilterContains(contains)).forEach(left->names.add(left));
                            containsWith.removeAll(names);
                            break;
                        case"Length":
                            Integer lenght = Integer.parseInt(parts[2]);
                            lenghtWith.stream().filter(AddFilterLenght(lenght)).forEach(left->names.add(left));
                            lenghtWith.removeAll(names);
                            break;
                    }
                    break;
                default:
                    break;
            }
            cmd = sc.nextLine();
        }

        names.stream().forEach(nm-> System.out.printf("%s ",nm));
    }

    private static Predicate<String> AddFilterStartsWith(String subString) {         //Predicate to filter(Remouve) all Starts
        return e -> e.substring(0, subString.length()).equals(subString);            //with given string
    }

    private static Predicate<String> AddFilterEndsWith(String subString) {           //Predicate to filter (Remouve)all Ends with
        return e -> e.substring(e.length() - subString.length()).equals(subString);  //given string
    }
    private static Predicate<String> AddFilterContains(String subString) {           //Predicate to filter (Remouve)all contains
        return e -> e.contains(subString);                                           //given string
    }
    private static Predicate<String> AddFilterLenght(Integer lenght) {               //Predicate to filter (Remouve)all with
        return e -> e.length()==lenght;                                              //given lenght
    }
}
