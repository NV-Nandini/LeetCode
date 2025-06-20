public class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        // Step 1: If total is odd, can't partition equally
        if (total % 2 != 0) return false;

        int target = total / 2;

        // Step 2: dp[i] = true if we can form sum i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // base case: 0 sum is always possible

        // Step 3: Try each num and update dp[]
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        // Step 4: Return if target sum is possible
        return dp[target];
    }
}
