class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string
        dp[1] = 1; // first char is valid since s.charAt(0) != '0'

        for (int i = 2; i <= n; i++) {
            char one = s.charAt(i - 1);
            char two1 = s.charAt(i - 2);

            // One-digit decode
            if (one >= '1' && one <= '9') {
                dp[i] += dp[i - 1];
            }

            // Two-digit decode
            int twoDigit = (two1 - '0') * 10 + (one - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
