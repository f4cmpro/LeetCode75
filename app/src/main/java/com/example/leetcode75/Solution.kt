package com.example.leetcode75

fun main() {
    val problem443 = Problem443()
    val strArr = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    val start = System.currentTimeMillis()
    val answers = problem443.compress(strArr)
    println("String Compression: $answers")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}