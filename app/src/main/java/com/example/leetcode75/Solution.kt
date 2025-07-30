package com.example.leetcode75

fun main() {
    val problem643 = Problem643()
    val nums = intArrayOf(1,12,-5,-6,50,3)
    val start = System.currentTimeMillis()
    println("Max Number of K-Sum Pairs: ${problem643.findMaxAverage(nums, 4)}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}