package com.example.leetcode75

fun main() {
    val problem11 = Problem11()
    val nums = intArrayOf(1,1)
    val start = System.currentTimeMillis()
    println("Container With Most Water: ${problem11.maxArea(nums)}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}