package leetcode.dp.climbingStairs

class Solution {
    var dp = IntArray(46)

    fun climbStairs(n: Int): Int {
        if (n <= 2) return n

        if (dp[n] != 0) return dp[n]

        dp[n] = climbStairs(n - 1) + climbStairs(n - 2)

        return dp[n]
    }
}
