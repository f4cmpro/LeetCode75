package com.example.leetcode75

fun main() {
    val problem = Problem394()
    val s = "2[abc]3[cd]ef"
    val start = System.currentTimeMillis()
    val answers = problem.decodeString(s)
    val end = System.currentTimeMillis()
    println("Decode String: $answers")
    println("Duration: ${end - start}ms")
}