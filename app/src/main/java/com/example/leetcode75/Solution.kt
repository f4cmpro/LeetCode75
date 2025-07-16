package com.example.leetcode75

fun main() {
    val problem238 = Problem238()
    val nums = intArrayOf(1, 2, 3, 5, 8, 14, 15, 16, 18, 19, 23, 29, 33, 36, 41, 42, 43, 44, 53, 59, 60, 61, 62, 64, 67, 76, 87, 92, 93, 97)
    val start = System.currentTimeMillis()
    print("answers: [")
    val answers = problem238.productExceptSelf(nums)
    answers.forEachIndexed { i, ans ->
        if (i == answers.lastIndex) {
            println("$ans]")
        } else {
            print("$ans, ")
        }
    }
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}