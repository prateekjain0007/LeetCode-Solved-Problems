import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, wordSet, memo);
    }

    private List<String> dfs(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add(""); // base case: empty string
            return res;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                List<String> suffixWays = dfs(s.substring(i), wordSet, memo);
                for (String suffix : suffixWays) {
                    res.add(prefix + (suffix.isEmpty() ? "" : " " + suffix));
                }
            }
        }

        memo.put(s, res);
        return res;
    }
}
