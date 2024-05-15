package leetcode.hashMap.jewelsAndStones

class Solution {
    fun numJewelsInStones(
        jewels: String,
        stones: String,
    ): Int {
        var count = 0
        val freqs: MutableSet<Char> = HashSet()

        for (jewel in jewels.toCharArray()) {
            freqs.add(jewel)
        }

        for (stone in stones.toCharArray()) {
            if (freqs.contains(stone)) count++
        }

        return count
    }
}
