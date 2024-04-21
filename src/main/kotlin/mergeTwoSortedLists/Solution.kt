package mergeTwoSortedLists

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        val answer =
            if (list1.`val` < list2.`val`) {
                list1.next = mergeTwoLists(list1.next, list2)
                list1
            } else {
                list2.next = mergeTwoLists(list2.next, list1)
                list2
            }

        return answer
    }
}
