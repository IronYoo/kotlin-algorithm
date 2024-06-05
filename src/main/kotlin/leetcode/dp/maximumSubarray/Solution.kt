package leetcode.dp.maximumSubarray

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val sums: MutableList<Int> = mutableListOf(nums[0])
        for (i in 1 until nums.size) {
            sums.add(nums[i] + if (sums[i - 1] > 0) sums[i - 1] else 0)
        }
        return sums.max()!!
    }
}
