package leetcode.graph.combinations

import java.util.LinkedList
import java.util.stream.Collectors

class Solution {
    fun combine(
        n: Int,
        k: Int,
    ): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(
            elements: LinkedList<Int>,
            start: Int,
            k: Int,
        ) {
            if (k == 0) {
                results.add(elements.stream().collect(Collectors.toList()))
                return
            }

            for (i in start..n) {
                elements.add(i)
                dfs(elements, i + 1, k - 1)
                elements.removeLast()
            }
        }

        dfs(LinkedList(), 1, k)
        return results
    }
}
