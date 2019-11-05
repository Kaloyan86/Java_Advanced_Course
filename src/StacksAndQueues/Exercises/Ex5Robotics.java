package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Ex5Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");

            robots[i] = data[0];
            processTime[i] = Integer.parseInt(data[1]);
        }
        String[] startTime = scanner.nextLine().split(":");

        ArrayDeque<String> products = new ArrayDeque<>();

        String inputProduct = "";
        while (!"End".equalsIgnoreCase(inputProduct = scanner.nextLine())) {
            products.offer(inputProduct);
        }
        int hours = Integer.parseInt(startTime[0]);
        int minutes = Integer.parseInt(startTime[1]);
        int seconds = Integer.parseInt(startTime[2]);

        int beginSeconds = hours * 3600 + minutes * 60 + seconds;

        while (!products.isEmpty()) {
            beginSeconds++;
            String product = products.poll();
            boolean isAssigned = false;
            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isAssigned) {
                    workTime[i] = processTime[i];
                    isAssigned = true;
                    printRobotData(robots[i], product, beginSeconds);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }
            if (!isAssigned) {
                products.offer(product);
            }
        }
    }

    private static void printRobotData(String robot, String product, int beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / 3600) % 24;
        System.out.println(String.format("%s - %s [%02d:%02d:%02d]", robot, product, h, m, s));
    }
}
