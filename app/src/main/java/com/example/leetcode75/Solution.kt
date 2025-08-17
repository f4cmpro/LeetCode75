package com.example.leetcode75

fun main() {
    val problem = Problem1657()
    val str1 = "aaabbbbccddeeeeefffff"
    val str2 = "aaaaabbcccdddeeeeffff"
    val start = System.currentTimeMillis()
    val answers = problem.closeStringsCopilot(str1, str2)
    val end = System.currentTimeMillis()
    println("Determine if Two Strings Are Close: $answers")
    println("Duration: ${end - start}ms")
}