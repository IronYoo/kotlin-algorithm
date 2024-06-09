package programmers.lessons92335

import kotlin.math.sqrt

class Solution {
    fun isPrime(num: Long): Boolean {
        if (num == 1L || (num > 2 && num % 2 == 0L)) return false

        for (i in 3..sqrt(num.toDouble()).toInt() step 2) {
            if (num % i == 0L) return false
        }
        return true
    }

    fun solution(
        n: Int,
        k: Int,
    ): Int {
        val str = n.toString(k)

        var answer = 0

        for (s in str.split("0").filter { it.isNotEmpty() }) {
            if (isPrime(s.toLong())) answer++
        }

        return answer
    }
}
