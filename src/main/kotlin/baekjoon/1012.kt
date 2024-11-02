fun main() {
    val t = readln().toInt()

    for (i in 0 until t) {
        bfs()
    }
}

fun bfs() {
    val (m, n, k) = readln().split(" ").map { it.toInt() }
    val box = MutableList(n) { MutableList(m) { 0 } }

    val points = mutableListOf<List<Int>>()
    for (i in 0 until k) {
        points.add(readln().split(" ").map { it.toInt() })
    }
    points.forEach { box[it[1]][it[0]] = 1 }

    var answer = 0
    val visited = MutableList(n) { MutableList(m) { false } }
    val next = listOf(listOf(0, 1), listOf(1, 0), listOf(0, -1), listOf(-1, 0))
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j]) continue
            if (box[i][j] != 1) continue

            val q = ArrayDeque<List<Int>>()
            q.addLast(listOf(i, j))
            while (q.isNotEmpty()) {
                val (x, y) = q.removeFirst()
                visited[x][y] = true

                next.forEach {
                    val nx = x + it[0]
                    val ny = y + it[1]

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && box[nx][ny] == 1 && !visited[nx][ny]) q.addLast(listOf(nx, ny))
                }
            }
            answer++
        }
    }
    println(answer)
}
