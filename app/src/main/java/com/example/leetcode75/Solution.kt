package com.example.leetcode75

fun main() {
    val problem283 = Problem283()
    val nums = intArrayOf(2,1,0,3,12)
    val start = System.currentTimeMillis()
    problem283.moveZeroes(nums)
    println("Move all 0's: ${nums.toList()}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}