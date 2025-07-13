package com.example.leetcode75

import kotlin.math.min

class Problem1768 {
    fun gcdOfStrings(str1: String, str2: String): String {
        for (i in min(str1.length, str2.length) downTo 1) {
            val gcd = str1.substring(0, i)
            if (isValid(str1, str2, gcd)) {
                return gcd
            }
        }
        return ""
    }

    private fun isValid(str1: String, str2: String, gcd: String): Boolean {
        if (str1.length % gcd.length > 0 || str2.length % gcd.length > 0) {
            return false
        }
        return str1.replace(gcd, "").isEmpty() && str2.replace(gcd, "").isEmpty()
    }
}