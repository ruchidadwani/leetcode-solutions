import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (isValid(curr)) {
                result.add(curr);
                found = true;
            }

            // Once valid strings are found at current level,
            // do not generate next level states
            if (found) continue;

            for (int i = 0; i < curr.length(); i++) {
                char ch = curr.charAt(i);

                // Remove only parentheses
                if (ch != '(' && ch != ')') continue;

                String next = curr.substring(0, i) + curr.substring(i + 1);

                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    private boolean isValid(String str) {
        int balance = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                if (balance == 0) return false;
                balance--;
            }
        }

        return balance == 0;
    }
}