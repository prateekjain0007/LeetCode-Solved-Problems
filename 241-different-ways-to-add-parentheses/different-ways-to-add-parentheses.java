import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return compute(expression, memo);
    }

    private List<Integer> compute(String expr, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expr)) return memo.get(expr);

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // Divide the expression
                String left = expr.substring(0, i);
                String right = expr.substring(i + 1);

                List<Integer> leftResults = compute(left, memo);
                List<Integer> rightResults = compute(right, memo);

                // Combine the results
                for (int l : leftResults) {
                    for (int r : rightResults) {
                        int result = 0;
                        if (c == '+') result = l + r;
                        else if (c == '-') result = l - r;
                        else if (c == '*') result = l * r;
                        results.add(result);
                    }
                }
            }
        }

        // Base case: expression is just a number
        if (results.isEmpty()) {
            results.add(Integer.parseInt(expr));
        }

        memo.put(expr, results);
        return results;
    }
}
