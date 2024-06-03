package leetcode.slidingWindow.slidingWindowMaximum

import java.util.ArrayDeque
import java.util.Deque

class Solution {
    fun maxSlidingWindow(
        nums: IntArray,
        k: Int,
    ): IntArray {
        val result: MutableList<Int> = mutableListOf()
        val dq: Deque<Int> = ArrayDeque()

        for (i in nums.indices) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll()

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast()

            dq.add(i)

            if (i >= k - 1) result.add(nums[dq.peek()])
        }
        return result.toIntArray()
    }
}
