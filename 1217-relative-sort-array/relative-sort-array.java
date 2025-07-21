class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Step 1: Add elements in order of arr2
        for (int num : arr2) {
            int count = freq.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
            freq.remove(num); // So we only sort the leftovers next
        }

        // Step 2: Sort remaining elements
        List<Integer> leftovers = new ArrayList<>();
        for (int num : freq.keySet()) {
            int count = freq.get(num);
            for (int i = 0; i < count; i++) {
                leftovers.add(num);
            }
        }

        Collections.sort(leftovers);
        result.addAll(leftovers);

        // Step 3: Convert to int[]
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }
}
