package leetcode.hashMap.topKFrequentElements

import java.util.PriorityQueue

class Solution {
    fun topKFrequent(
        nums: IntArray,
        k: Int,
    ): IntArray {
        val frequencyMap: MutableMap<Int, Int> = mutableMapOf()

        for (n in nums) {
            frequencyMap[n] = frequencyMap.getOrDefault(n, 0) + 1
        }

        val pq: PriorityQueue<IntArray> = PriorityQueue { a: IntArray, b: IntArray -> b[1] - a[1] }

        for (e in frequencyMap.keys) {
            pq.add(intArrayOf(e, frequencyMap[e]!!))
        }

        val result = IntArray(k)

        for (i in 0 until k) {
            result[i] = pq.poll()[0]
        }

        return result
    }
}
