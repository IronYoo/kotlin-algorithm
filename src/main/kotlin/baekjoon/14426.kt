fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
//    println("$n, $m")
    val arr = mutableListOf<String>()
    repeat(n) {
        arr.add(readln())
    }
//    println(arr)

    val subArr = mutableListOf<String>()
    repeat(m) {
        subArr.add(readln())
    }

//    println(subArr)

    var cnt = 0
    for (s in subArr) {
        for (a in arr) {
            if (a.startsWith(s)) {
                cnt++
                break
            }
        }
    }

    println(cnt)
}
