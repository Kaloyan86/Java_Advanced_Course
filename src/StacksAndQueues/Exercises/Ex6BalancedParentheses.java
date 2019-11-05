package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Ex6BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> opening = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
                opening.push(input.charAt(i));
            } else {
                if (opening.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char open = opening.pop();
                if (open != '{' && input.charAt(i) == '}') {
                    isBalanced = false;
                    break;
                } else if (open != '(' && input.charAt(i) == ')') {
                    isBalanced = false;
                    break;
                } else if (open != '[' && input.charAt(i) == ']') {
                    isBalanced = false;
                    break;

                }
            }


        }
        if (!isBalanced) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
