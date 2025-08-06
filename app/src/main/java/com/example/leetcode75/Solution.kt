package com.example.leetcode75

fun main() {
    val problem = Problem1732()
    val nums = intArrayOf(-4,-3,-2,-1,4,3,2)
    val start = System.currentTimeMillis()
    println("Find the Highest Altitude: ${problem.largestAltitude(nums)}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}