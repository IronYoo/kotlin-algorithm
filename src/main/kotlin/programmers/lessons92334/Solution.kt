package programmers.lessons92334

class Solution {
    fun solution(
        id_list: Array<String>,
        report: Array<String>,
        k: Int,
    ): IntArray {
        val reportSet: Set<String> = report.toSet()

        val reportLog: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (set in reportSet) {
            val person = set.split(" ")
            val list = reportLog.getOrDefault(person[1], mutableListOf())
            list.add(person[0])
            reportLog[person[1]] = list
        }

        val mailCounts = mutableMapOf<String, Int>()

        for (log in reportLog) {
            if (log.value.size >= k) {
                for (people in log.value) {
                    mailCounts[people] = mailCounts.getOrDefault(people, 0 + 1)
                }
            }
        }

        return id_list.map { x -> mailCounts.getOrDefault(x, 0) }.toIntArray()
    }
}
