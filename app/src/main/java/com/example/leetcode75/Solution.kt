package com.example.leetcode75

fun main() {
    val problem1004 = Problem1004()
    val nums = intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1)
    val start = System.currentTimeMillis()
    println("Max Consecutive Ones III: ${problem1004.longestOnes(nums, 3)}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}