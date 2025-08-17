package com.example.leetcode75

fun main() {
    val problem = Problem1207()
    val nums = intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)
    val start = System.currentTimeMillis()
    val answers = problem.uniqueOccurrences(nums)
    val end = System.currentTimeMillis()
    println("Unique Number of Occurrences: $answers")
    println("Duration: ${end - start}ms")
}