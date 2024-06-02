package leetcode.sort.mergeIntervals

import kotlin.math.max

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val merged: MutableList<IntArray> = mutableListOf()
        intervals.sortWith(Comparator { o1, o2 -> o1[0] - o2[0] })

        for (i in intervals) {
            if (merged.isNotEmpty() && i[0] <= merged[merged.size - 1][1]) {
                merged[merged.size - 1][1] = max(merged[merged.size - 1][1], i[1])
            } else {
                merged.add(i)
            }
        }

        return merged.toTypedArray()
    }
}
