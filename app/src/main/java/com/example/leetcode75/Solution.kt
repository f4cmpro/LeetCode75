package com.example.leetcode75

fun main() {
    val problem1679 = Problem1679()
    val nums = intArrayOf(1,2,3,4)
    val start = System.currentTimeMillis()
    println("Max Number of K-Sum Pairs: ${problem1679.maxOperations(nums, 5)}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}