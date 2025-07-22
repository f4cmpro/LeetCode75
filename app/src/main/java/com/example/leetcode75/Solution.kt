package com.example.leetcode75

fun main() {
    val problem392 = Problem392()
    val start = System.currentTimeMillis()
    println("Is Subsequence: ${problem392.isSubsequence(s = "doan tu", t = "doan le tuan tu")}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}