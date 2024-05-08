package leetcode.stack.validParentheses

import java.util.ArrayDeque
import java.util.Deque

class Solution {
    fun isValid(s: String): Boolean {
        val stack: Deque<Char> = ArrayDeque()
        val table: Map<Char, Char> =
            mapOf(
                ')' to '(',
                '}' to '{',
                ']' to '[',
            )

        for (i in s.indices) {
            if (!table.containsKey(s[i])) {
                stack.push(s[i])
            } else if (stack.isEmpty() || table[s[i]] != stack.pop()) {
                return false
            }
        }

        return stack.size == 0
    }
}
