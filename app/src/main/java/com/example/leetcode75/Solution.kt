package com.example.leetcode75

fun main() {
    val problem = Problem1493()
    val nums = intArrayOf(0,0,0,0)
    val start = System.currentTimeMillis()
    println("Longest Subarray of 1's After Deleting One Element: ${problem.longestSubarray(nums)}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}