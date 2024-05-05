package leetcode.array.arrayPartition

class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        var sum = 0
        nums.sort()

        for ((i, n) in nums.withIndex()) {
            if (i % 2 == 0) sum += n
        }

        return sum
    }
}
