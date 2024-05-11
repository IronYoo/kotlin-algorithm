package leetcode.stack.implementStackUsingQueues

import java.util.*

class MyStack {
    val queue: Deque<Int> = LinkedList<Int>()

    fun push(x: Int) {
        queue.add(x)
        for (i in 1 until queue.size) {
            queue.add(queue.remove())
        }
    }

    fun pop(): Int = queue.remove()

    fun top(): Int = queue.peek()

    fun empty(): Boolean = queue.size == 0
}
