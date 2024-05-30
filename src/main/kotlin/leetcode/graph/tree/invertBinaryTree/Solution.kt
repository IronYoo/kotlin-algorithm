package leetcode.graph.tree.invertBinaryTree

import leetcode.graph.tree.TreeNode

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root != null) {
            root.left = root.right.also { root.right = root.left }

            invertTree(root.left)
            invertTree(root.right)
        }

        return root
    }
}
