package com.example.leetcode75

fun main() {
    val problem = Problem649()
    val start = System.currentTimeMillis()
    val answers = problem.predictPartyVictory(
        senate = "DDRRR"
    )
    val end = System.currentTimeMillis()
    println("Dota2 Senate: $answers")
    println("Duration: ${end - start}ms")
}