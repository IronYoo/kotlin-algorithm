package leetcode.dp.houseRobber

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = dp[0].coerceAtLeast(nums[1])

        for (i in 2 until nums.size) {
            dp[i] = dp[i - 1].coerceAtLeast(dp[i - 2] + nums[i])
        }

        return dp[nums.size - 1]
    }
}
