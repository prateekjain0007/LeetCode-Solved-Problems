class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
      char s1[]=s.toCharArray();
      char t1[]=t.toCharArray();
      Arrays.sort(s1);
    Arrays.sort(t1);
      for(int i=0;i<s.length();i++){
        if(s1[i]!=t1[i]){
            return false;
        }
      }  
      return true;
    }
}


/*class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // count characters in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // subtract characters in t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c); // optional, keeps map clean
        }

        // if map is empty, all counts matched
        return map.isEmpty();
    }
}*/
