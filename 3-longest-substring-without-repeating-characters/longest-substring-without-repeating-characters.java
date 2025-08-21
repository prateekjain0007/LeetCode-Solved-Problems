class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxLen=0;
        HashSet<Character> set=new HashSet<>();
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
             while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add new character
            set.add(c);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
        }
    }
