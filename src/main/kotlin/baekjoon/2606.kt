fun main() {
    val c = readLine()!!.toInt()
    val n = readLine()!!.toInt()

    val pair = mutableMapOf<Int, MutableList<Int>>()
    repeat(n) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        pair[x] = pair.getOrDefault(x, mutableListOf()).apply { add(y) }
        pair[y] = pair.getOrDefault(y, mutableListOf()).apply { add(x) }
    }

    val visited = MutableList(c + 1) { false }
    visited[1] = true

    var answer = 0

    fun dfs(left: List<Int>) {
        left.forEach {
            if (!visited[it]) {
                visited[it] = true
                answer++
                dfs(pair[it]!!.toList())
            }
        }
    }
    dfs(pair[1] ?: listOf())

    print(answer)
}
