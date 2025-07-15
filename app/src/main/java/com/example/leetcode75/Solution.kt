package com.example.leetcode75

fun main() {
    val problem151 = Problem151()
    println("before:    Doan,   Le$*#* Tuan  ,,,, Tu   !_)@#,, A}|P{P{ ")
    val start = System.currentTimeMillis()
    println("reversed: ${problem151.reverseWords("   Doan,   Le\$*#* Tuan  ,,,, Tu   !_)@#,, A}|P{P{ ")}")
    val end = System.currentTimeMillis()
    println("Duration: ${end - start}ms")
}