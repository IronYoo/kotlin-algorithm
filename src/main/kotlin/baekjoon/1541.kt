fun main() = println(readln().split("-").map { s -> s.split("+").sumOf { it.toInt() } }.reduce { a, c -> a - c })
