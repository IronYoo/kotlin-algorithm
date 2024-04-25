package leetcode.linnkedList.swapNodesinPairs

class ListNode(
    var `val`: Int,
) {
    var next: ListNode? = null
}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next != null) {
            val p = head.next
            head.next = swapPairs(head.next!!.next)
            if (p != null) {
                p.next = head
            }
            return p
        }

        return head
    }
}
