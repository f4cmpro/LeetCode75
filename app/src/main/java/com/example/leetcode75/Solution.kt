package com.example.leetcode75

fun main() {
    val problem1456 = Problem1456()
    val str = "leetcode"
    val start = System.currentTimeMillis()
    println("Maximum Number of Vowels in a Substring of Given Length: ${problem1456.maxVowels(str, 3)}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}