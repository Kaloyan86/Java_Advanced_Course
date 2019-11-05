package StacksAndQueues.Lab;

import java.util.*;

public class Lab2SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stackReversed = new ArrayDeque<>();
        String exp = scanner.nextLine();
        Arrays.stream(exp.split("\\s+")).forEach(stack::push);

        while (!stack.isEmpty()){
            stackReversed.push(stack.pop());
        }

        while (stackReversed.size() > 1) {
            int firstNum = Integer.parseInt(stackReversed.pop());
            String operation = stackReversed.pop();
            int secondNum = Integer.parseInt(stackReversed.pop());

            if ("+".equalsIgnoreCase(operation)){
                stackReversed.push(firstNum + secondNum + "");
            }else {
                stackReversed.push(firstNum - secondNum + "");

            }
        }
        System.out.println(stackReversed.peek());
    }
}
