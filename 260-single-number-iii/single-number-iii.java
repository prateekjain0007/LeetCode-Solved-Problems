class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers -> a ^ b
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find a set bit (rightmost set bit)
        int diffBit = xor & (-xor);

        // Step 3: Separate numbers into two groups and XOR each
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
