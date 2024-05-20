package leetcode.graph.permutation

import java.util.Arrays
import java.util.stream.Collectors
import kotlin.collections.ArrayList

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(
            prevElements: MutableList<Int>,
            elements: List<Int>,
        ) {
            if (elements.isEmpty()) {
                results.add(prevElements.stream().collect(Collectors.toList()))
            }

            for (e in elements) {
                val nextElements: MutableList<Int> = ArrayList(elements)
                nextElements.add(e)

                dfs(prevElements, nextElements)
            }
        }

        val lst = Arrays.stream(nums).boxed().collect(Collectors.toList())

        dfs(mutableListOf(), lst)

        return results
    }
}
