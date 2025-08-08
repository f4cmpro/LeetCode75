package com.example.leetcode75

fun main() {
    val problem = Problem2215()
    val nums1 = intArrayOf(1,2,3,3)
    val nums2 = intArrayOf(1,1,2,2)
    val start = System.currentTimeMillis()
    val answers = problem.findDifference(nums1, nums2)
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
    println("Find the Difference of Two Arrays:")
    val ans1 = answers[0]
    print("ans1: [")
    for (i in ans1.indices) {
        if (i == ans1.lastIndex) {
            println("${ans1[i]}]")
        } else {
            print("${ans1[i]}, ")
        }
    }
    print("ans2: [")
    val ans2 = answers[1]
    for (i in ans2.indices) {
        if (i == ans2.lastIndex) {
            println("${ans2[i]}]")
        } else {
            print("${ans2[i]}, ")
        }
    }
}