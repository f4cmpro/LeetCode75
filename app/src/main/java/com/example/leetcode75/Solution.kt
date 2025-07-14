package com.example.leetcode75

fun main() {
    val problem345 = Problem345()
    println("before: A man, a plan, a canal: Panama")
    val start = System.currentTimeMillis()
    println("reversed: ${problem345.reverseVowels("A man, a plan, a canal: Panama")}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}