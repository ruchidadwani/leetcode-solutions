import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, 0, 0, 0, "");
        return result;
    }

    private void backtrack(List<String> result, String num, int target,
                           int index, long currentValue, long lastOperand, String expr) {

        // Base case
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Avoid leading zeros
            if (i != index && num.charAt(index) == '0') break;

            String part = num.substring(index, i + 1);
            long currentNum = Long.parseLong(part);

            if (index == 0) {
                // First number (no operator)
                backtrack(result, num, target, i + 1, currentNum, currentNum, part);
            } else {
                // +
                backtrack(result, num, target, i + 1,
                        currentValue + currentNum,
                        currentNum,
                        expr + "+" + part);

                // -
                backtrack(result, num, target, i + 1,
                        currentValue - currentNum,
                        -currentNum,
                        expr + "-" + part);

                // *
                backtrack(result, num, target, i + 1,
                        currentValue - lastOperand + (lastOperand * currentNum),
                        lastOperand * currentNum,
                        expr + "*" + part);
            }
        }
    }
}