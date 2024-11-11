package programmers.lessons172928

class Solution {
    fun solution(
        park: Array<String>,
        routes: Array<String>,
    ): IntArray {
        val dir =
            mapOf(
                "N" to Pair(-1, 0),
                "S" to Pair(1, 0),
                "W" to Pair(0, -1),
                "E" to Pair(0, 1),
            )

        val box = park.map { it.toCharArray() }

        lateinit var nowPoint: Pair<Int, Int>
        for (x in box.indices) {
            for (y in box[x].indices) {
                if (box[x][y] == 'S') nowPoint = Pair(x, y)
            }
        }

        val routePoints =
            routes.map {
                val route = it.split(" ")
                val pair = dir[route[0]]!!
                val by = route[1].toInt()
                Pair(pair.first * by, pair.second * by)
            }

        for (route in routePoints) {
            val newPoint = Pair(nowPoint.first + route.first, nowPoint.second + route.second)
            if (
                newPoint.first in 0 until box.size &&
                newPoint.second in 0 until box[0].size &&
                box[newPoint.first][newPoint.second] != 'X'
            ) {
                nowPoint = newPoint
            }
        }

        return intArrayOf(nowPoint.first, nowPoint.second)
    }
}
