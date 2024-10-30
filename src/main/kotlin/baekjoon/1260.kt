fun main() {
    val inputs = readln().split(" ").map { it.toInt() }
    val n = inputs[0]
    val m = inputs[1]
    val v = inputs[2]
    val graphs = mutableMapOf<Int, MutableList<Int>>()

    for (i in 0 until m) {
        val graph = readln().split(" ").map { it.toInt() }
        val newGraph1 = graphs.getOrDefault(graph[0], mutableListOf())
        newGraph1.add(graph[1])
        graphs[graph[0]] = newGraph1

        val newGraph2 = graphs.getOrDefault(graph[1], mutableListOf())
        newGraph2.add(graph[0])
        graphs[graph[1]] = newGraph2
    }

    // DFS
    val answer1 = mutableListOf<Int>()
    val visited2 = MutableList(n + 1) { false }

    fun dfs(list: List<Int>) {
        for (l in list) {
            if (!visited2[l]) {
                answer1.add(l)
                visited2[l] = true
                val nextPoints = graphs.getOrDefault(l, listOf()).sortedWith(Comparator { o1, o2 -> o1.compareTo(o2) })
                if (nextPoints.isNotEmpty())dfs(nextPoints)
            }
        }
    }
    dfs(listOf(v))

    //  BFS
    val answer2 = mutableListOf<Int>()
    val q = ArrayDeque<Int>()
    val visited = MutableList(n + 1) { false }
    q.addLast(v)

    while (q.isNotEmpty()) {
        val msg = q.removeFirst()

        if (!visited[msg]) answer2.add(msg)
        visited[msg] = true

        val nextPoints = graphs.getOrDefault(msg, listOf()).sortedWith(Comparator { o1, o2 -> o1.compareTo(o2) })
        for (next in nextPoints) {
            if (!visited[next]) q.add(next)
        }
    }

    println(answer1.joinToString(" "))
    print(answer2.joinToString(" "))
}
