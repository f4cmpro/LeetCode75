package com.example.leetcode75

fun main() {
    val problem = Problem933()
    val start = System.currentTimeMillis()
    val answers = problem.countRequests(
        times = mutableListOf(
            intArrayOf(),
            intArrayOf(2196),
            intArrayOf(3938),
            intArrayOf(4723),
            intArrayOf(4775),
            intArrayOf(5952),
        ).toTypedArray()
    )
    val end = System.currentTimeMillis()
    print("Number of Recent Calls: [")
    for (i in answers.indices) {
        val ans = answers[i]
        if (i == answers.lastIndex) {
            println("$ans]")
        } else {
            print("$ans, ")
        }
    }
    println("Duration: ${end - start}ms")
}