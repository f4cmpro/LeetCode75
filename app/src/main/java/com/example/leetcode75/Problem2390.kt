package com.example.leetcode75

import java.util.Stack

/**
 * 2390. Removing Stars From a String
 * Easy
 * You are given a string s, which contains stars *.
 * In one operation, you can:
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * Note:
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 *
 * Example 1:
 * Input: s = "leet**cod*e"
 * Output: "lecoe"
 * Explanation: Performing the removals from left to right:
 * - The closest character to the 1st star is 't' in "leet**cod*e". After removing both, s = "lee*cod*e".
 * - The closest character to the 2nd star is 'e' in "lee*cod*e". After removing both, s = "lcod*e".
 * - The closest character to the 3rd star is 'd' in "lcod*e". After removing both, s = "lcoe".
 *
 * Example 2:
 * Input: s = "erase*****"
 * Output: ""
 * Explanation: The entire string is removed, so we return an empty string.
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters and stars *.
 * The operation above can be performed on s.
 */
class Problem2390 {
    //My solution
    fun removeStars(s: String): String {
        val output = Stack<Char>()
        var skipCount = 0
        for (i in s.lastIndex downTo 0) {
            if (s[i] != '*') {
                if (skipCount == 0) {
                    output.push(s[i])
                } else {
                    skipCount--
                }
            } else {
                skipCount++
            }
        }
        return output.joinToString("").reversed()
    }

    //LeetCode
    fun removeStarsLeetCode(s: String): String {
        val res = StringBuilder()

        for (char in s) {
            when (char) {
                '*' -> res.deleteAt(res.length - 1)
                else -> res.append(char)
            }
        }

        return res.toString()
    }
    //Copilot
    fun removeStarsCopilot(s: String): String {
        val stack = Stack<Char>()
        for (char in s) {
            if (char == '*') {
                if (stack.isNotEmpty()) {
                    stack.pop()
                }
            } else {
                stack.push(char)
            }
        }
        return stack.joinToString("")
    }
}