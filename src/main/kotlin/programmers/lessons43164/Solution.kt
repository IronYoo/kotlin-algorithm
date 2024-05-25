package programmers.lessons43164

import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList
import java.util.PriorityQueue

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val fromToMap: MutableMap<String, PriorityQueue<String>> = mutableMapOf()

        for (ticket in tickets) {
            fromToMap.putIfAbsent(ticket[0], PriorityQueue())
            fromToMap[ticket[0]]!!.add(ticket[1])
        }

        val answer: MutableList<String> = LinkedList()
        val stack: Deque<String> = ArrayDeque()

        stack.push("ICN")
        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.first) && !fromToMap[stack.first]!!.isEmpty()) {
                stack.push(fromToMap[stack.first]!!.poll())
            }

            answer.add(0, stack.pop())
        }

        return answer.toTypedArray()
    }
}
