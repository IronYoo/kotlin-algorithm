package leetcode.stack.implementQueueUsingStacks

import java.util.ArrayDeque
import java.util.Deque

class Solution {
    val input: Deque<Int> = ArrayDeque()
    val output = ArrayDeque<Int>()

    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        peek()
        return output.pop()
    }

    fun peek(): Int {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop())
            }
        }
        return output.peek()
    }

    fun empty(): Boolean = input.isEmpty() && output.isEmpty()
}
