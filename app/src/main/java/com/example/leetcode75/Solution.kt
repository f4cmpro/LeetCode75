package com.example.leetcode75

fun main() {
    val problem334 = Problem334()
    val nums = intArrayOf(1,5,0,4,1,3)
    val start = System.currentTimeMillis()
    val answers = problem334.increasingTriplet(nums)
    println("Increasing Triplet Subsequence: $answers")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}