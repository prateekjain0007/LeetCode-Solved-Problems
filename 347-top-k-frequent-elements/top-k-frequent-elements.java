class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
        map.put(num, map.getOrDefault(num,0)+1);
        }
          List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Step 3: Sort list by frequency (value) in descending order
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Pick top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}