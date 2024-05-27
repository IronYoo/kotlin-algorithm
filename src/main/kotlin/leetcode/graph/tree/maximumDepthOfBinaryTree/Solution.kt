package leetcode.graph.tree.maximumDepthOfBinaryTree

import java.util.LinkedList
import java.util.Queue

var ti = TreeNode(5)
var v = ti.`val`

class TreeNode(
    var `val`: Int,
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        var depth = 0

        while (!q.isEmpty()) {
            depth++
            val qSize = q.size

            for (i in 0 until qSize) {
                val cur = q.poll()
                if (cur.left != null) {
                    q.add(cur.left)
                }

                if (cur.right != null) {
                    q.add(cur.right)
                }
            }
        }

        return depth
    }
}
