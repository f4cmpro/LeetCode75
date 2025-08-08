package com.example.leetcode75

fun main() {
    val problem = Problem724()
    val nums = intArrayOf(1,7,3,6,5,6)
    val start = System.currentTimeMillis()
    println("Find Pivot Index: ${problem.pivotIndex(nums)}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}