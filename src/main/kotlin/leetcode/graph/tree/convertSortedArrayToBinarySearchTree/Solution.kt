package leetcode.graph.tree.convertSortedArrayToBinarySearchTree

import leetcode.graph.tree.TreeNode

class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun construct(
            lo: Int,
            hi: Int,
        ): TreeNode? {
            if (lo > hi) return null

            val mid = lo + (hi - lo) / 2

            val node = TreeNode(nums[mid])

            node.left = construct(lo, mid - 1)
            node.right = construct(mid + 1, hi)

            return node
        }

        return if (nums.isEmpty()) {
            null
        } else {
            construct(0, nums.size - 1)
        }
    }
}
