package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(isBalanced(scanner.nextLine(), map));
        }
    }

    private static boolean isBalanced(String input, Map<String, String> map) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            String string = input.substring(i, i + 1);
            if (map.containsKey(string)) {
                stack.push(string);
            } else if (stack.isEmpty() || !string.equals(map.get(stack.pop()))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}