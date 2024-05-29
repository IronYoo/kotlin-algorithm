package leetcode.graph.tree.longestUnivaluePath

import leetcode.graph.tree.TreeNode
import kotlin.math.max

class Solution {
    fun longestUnivaluePath(root: TreeNode?): Int {
        var result = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            var left = dfs(node.left)
            var right = dfs(node.right)

            if (node.left != null && node.left!!.`val` == node.`val`) {
                left += 1
            } else {
                left = 0
            }

            if (node.right != null && node.right!!.`val` == node.`val`) {
                right += 1
            } else {
                right = 0
            }

            result = max(result, left + right)
            return max(left, right)
        }

        dfs(root)
        return result
    }
}
