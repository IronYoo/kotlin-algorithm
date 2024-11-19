package programmers.l340211

class Solution {
    fun solution(
        points: Array<IntArray>,
        routes: Array<IntArray>,
    ): Int {
        // Func to get coordinates given a point number
        fun getPointCoords(pointNum: Int): Pair<Int, Int> {
            val index = pointNum - 1
            return Pair(points[index][0], points[index][1])
        }

        // Tracks the positions of robots at every time step
        val currentPositions = Array(routes.size) { Pair(0, 0) }
        val routeIndices = IntArray(routes.size) { 0 }
        val completed = BooleanArray(routes.size) { false }

        // Initialize positions of robots
        for (i in routes.indices) {
            currentPositions[i] = getPointCoords(routes[i][0])
        }

        var time = 0
        var dangerCount = 0

        // Simulation loop
        while (completed.any { !it }) {
            val positionCount = mutableMapOf<Pair<Int, Int>, Int>()

            // Move all robots
            for (i in routes.indices) {
                if (completed[i]) continue

                val currentIndex = routeIndices[i]
                val currentPos = currentPositions[i]
                val nextPos = getPointCoords(routes[i][currentIndex + 1])

                // Decide movement direction towards next point
                val newPos =
                    when {
                        currentPos.first < nextPos.first -> Pair(currentPos.first + 1, currentPos.second)
                        currentPos.first > nextPos.first -> Pair(currentPos.first - 1, currentPos.second)
                        currentPos.second < nextPos.second -> Pair(currentPos.first, currentPos.second + 1)
                        currentPos.second > nextPos.second -> Pair(currentPos.first, currentPos.second - 1)
                        else -> nextPos
                    }

                // Update position
                currentPositions[i] = newPos
                positionCount[newPos] = positionCount.getOrDefault(newPos, 0) + 1

                // Check if reached next point in route
                if (newPos == nextPos) {
                    routeIndices[i] = currentIndex + 1
                    if (routeIndices[i] == routes[i].size - 1) {
                        completed[i] = true
                    }
                }
            }

            // Count danger situations
            dangerCount += positionCount.values.count { it > 1 }

            time++
        }

        return dangerCount
    }
}
