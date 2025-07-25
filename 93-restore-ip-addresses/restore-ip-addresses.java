class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String s, int index, String current, int segments) {
        if (segments == 4 && index == s.length()) {
            result.add(current);
            return;
        }

        if (segments >= 4 || index >= s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            // Skip invalid segments
            if ((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255) {
                continue;
            }

            String newCurrent = segments == 0 ? part : current + "." + part;
            backtrack(result, s, index + len, newCurrent, segments + 1);
        }
    }
}
