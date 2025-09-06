package com.example.leetcode75

fun main() {
    val problem = Problem2390()
    val str = "erase*****"
    val start = System.currentTimeMillis()
    val answers = problem.removeStarsCopilot(str)
    val end = System.currentTimeMillis()
    println("Removing Stars From a String: $answers")
    println("Duration: ${end - start}ms")
}