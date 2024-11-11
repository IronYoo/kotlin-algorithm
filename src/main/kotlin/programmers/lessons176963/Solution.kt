package programmers.lessons176963

class Solution {
    fun solution(
        name: Array<String>,
        yearning: IntArray,
        photo: Array<Array<String>>,
    ): IntArray {
        val score = mutableMapOf<String, Int>()

        name.withIndex().forEach { (index, name) ->
            score[name] = yearning[index]
        }

        val answer = mutableListOf<Int>()
        photo.forEach { people ->
            answer.add(people.fold(0) { acc, cur -> acc + score.getOrDefault(cur, 0) })
        }

        return answer.toIntArray()
    }
}
