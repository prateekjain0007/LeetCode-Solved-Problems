class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from the left
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            // Skip non-alphanumeric characters from the right
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            // Compare characters ignoring case
         if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // mismatch found
            }
            left++;
            right--;
        }
        return true; // no mismatches
    }
}
