class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> map = new HashMap<>();
           for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
               // If key not in map, create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add string to correct group
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}