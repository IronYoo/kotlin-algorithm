package leetcode.hashMap.longestSubstringWithoutRepeatingCharacters

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val used: MutableMap<Char, Int> = mutableMapOf()
        var maxLength = 0
        var left = 0
        var right = 0

        for (c in s.toCharArray()) {
            if (left <= used.getOrDefault(c, -1)) {
                left = used[c]!! + 1
            } else {
                maxLength = max(maxLength, right - left + 1)
            }

            used[c] = right
            right++
        }

        return maxLength
    }
}
