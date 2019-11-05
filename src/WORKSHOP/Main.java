package WORKSHOP;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        smartArray.add(24);
        smartArray.add(25);
        smartArray.add(26);

        smartArray.remove(1);
        smartArray.forEach(System.out::println);

    }
}
