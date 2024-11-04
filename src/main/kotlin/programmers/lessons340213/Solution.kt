package programmers.lessons340213

import java.time.LocalDateTime

class Solution {
    fun solution(
        video_len: String,
        pos: String,
        op_start: String,
        op_end: String,
        commands: Array<String>,
    ): String {
        var answer: String = ""

        val (mm, ss) = pos.split(":").map { it.toInt() }
        var time = LocalDateTime.of(2024, 12, 10, 0, mm, ss)

        val (videoMm, videoSs) = video_len.split(":").map { it.toInt() }
        val videoTime = LocalDateTime.of(2024, 12, 10, 0, videoMm, videoSs)

        val (opStartMm, opStartSs) = op_start.split(":").map { it.toInt() }
        val opStart = LocalDateTime.of(2024, 12, 10, 0, opStartMm, opStartSs)

        val (opEndMm, opEndSs) = op_end.split(":").map { it.toInt() }
        val opEnd = LocalDateTime.of(2024, 12, 10, 0, opEndMm, opEndSs)

        if (time in opStart..opEnd) time = opEnd
        commands.forEach {
            when (it) {
                "next" -> {
                    val newTime = time.plusSeconds(10)
                    time = if (newTime >= videoTime) videoTime else newTime

                    if (time in opStart..opEnd) time = opEnd
                }
                "prev" -> {
                    val newTime = time.minusSeconds(10)
                    time =
                        if (newTime.isBefore(LocalDateTime.of(2024, 12, 10, 0, 0, 0))) LocalDateTime.of(2024, 12, 10, 0, 0, 0) else newTime

                    if (time in opStart..opEnd) time = opEnd
                }
            }
        }

        return String.format("%02d:%02d", time.minute, time.second)
    }
}

fun main() {
    println(Solution().solution("10:00", "00:03", "00:00", "00:05", arrayOf("prev", "next")))
}
