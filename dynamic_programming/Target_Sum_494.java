//494. Target Sum

/*

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.



*/


class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        
        
        if (nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, S, 0, 0, 0);
        
    }
    
    public int subsetSum(int[] nums, int s) {
        int [] dp = new int[s+1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
    
    
     public int helper(int[] nums, int S, int sum, int index, int count){
        if (index == nums.length){
            if (sum == S){
                count ++;
            }
            return count;
        }
        return helper(nums, S, sum + nums[index], index + 1, count) + helper(nums, S, sum - nums[index], index + 1, count);
    }
}