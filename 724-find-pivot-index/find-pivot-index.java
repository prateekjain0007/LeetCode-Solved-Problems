class Solution {
    public int pivotIndex(int[] nums) {
        // Step 1: find total sum
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // Step 2: iterate to find pivot
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {

            // 1️⃣ CHECK
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i; // pivot found
            }

            // 2️⃣ UPDATE for next iteration
            leftSum = leftSum + nums[i];
        }

        // no pivot found
        return -1;
    }
}
