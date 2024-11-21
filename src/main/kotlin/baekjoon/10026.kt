fun main() {
    val n = readln().toInt()

    val grid = mutableListOf<List<Char>>()

    repeat(n) {
        grid.add(readln().toCharArray().toList())
    }

    val dir =
        listOf(
            Pair(1, 0),
            Pair(-1, 0),
            Pair(0, 1),
            Pair(0, -1),
        )

    fun bfs1(
        grid: List<List<Char>>,
        n: Int,
    ): Int {
        val mappers =
            mapOf(
                'R' to listOf('R'),
                'G' to listOf('G'),
                'B' to listOf('B'),
            )
        var cnt = 0
        val visited = List(n) { MutableList(n) { false } }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j]) {
                    cnt++
                    val q = ArrayDeque<Pair<Int, Int>>()
                    visited[i][j] = true
                    q.addLast(Pair(i, j))
                    val mapper = mappers[grid[i][j]]!!

                    while (q.isNotEmpty()) {
                        val (x, y) = q.removeFirst()

                        for (d in dir) {
                            val (dx, dy) = d
                            val (nx, ny) = listOf(x + dx, y + dy)

                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                                if (grid[nx][ny] in mapper) {
                                    visited[nx][ny] = true
                                    q.addLast(Pair(nx, ny))
                                }
                            }
                        }
                    }
                }
            }
        }
        return cnt
    }

    fun bfs2(
        grid: List<List<Char>>,
        n: Int,
    ): Int {
        val mappers =
            mapOf(
                'R' to listOf('R', 'G'),
                'G' to listOf('R', 'G'),
                'B' to listOf('B'),
            )
        var cnt = 0
        val visited = List(n) { MutableList(n) { false } }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j]) {
                    cnt++
                    val q = ArrayDeque<Pair<Int, Int>>()
                    visited[i][j] = true
                    q.addLast(Pair(i, j))
                    val mapper = mappers[grid[i][j]]!!

                    while (q.isNotEmpty()) {
                        val (x, y) = q.removeFirst()

                        for (d in dir) {
                            val (dx, dy) = d
                            val (nx, ny) = listOf(x + dx, y + dy)

                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                                if (grid[nx][ny] in mapper) {
                                    visited[nx][ny] = true
                                    q.addLast(Pair(nx, ny))
                                }
                            }
                        }
                    }
                }
            }
        }
        return cnt
    }

    val cnt1 = bfs1(grid, n)
    val cnt2 = bfs2(grid, n)
    println("$cnt1 $cnt2")
    println(grid.indices)
}
