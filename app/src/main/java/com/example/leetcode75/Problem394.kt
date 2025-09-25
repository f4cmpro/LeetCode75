package com.example.leetcode75

import java.util.Stack

/**
 * 394. Decode String
 * Medium
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
class Problem394 {
    //My solution
    // Duration: 11ms
    // Time complexity: O(n^2) in worst case when we have nested brackets
    fun decodeString(s: String): String {
        fun isDigit(char: Char): Boolean {
            return char in '0'..'9'
        }

        fun isLeftSquareBracket(char: Char): Boolean {
            return char == '['
        }

        fun isRightSquareBracket(char: Char): Boolean {
            return char == ']'
        }
        val strStack = Stack<Char>()
        for (char in s) {
            if (isRightSquareBracket(char)) {
                val stringBuilder = StringBuilder()
                while (strStack.isNotEmpty()) {
                    val char1 = strStack.pop()
                    if (isLeftSquareBracket(char1)) {
                        val repeat = StringBuilder()
                        while (strStack.isNotEmpty() && isDigit(strStack.peek())) {
                            val digitChar = strStack.pop()
                            repeat.append(digitChar)
                        }
                        for (i in 1..repeat.reverse().toString().toInt()) {
                            stringBuilder.toString().reversed().forEach {
                                strStack.push(it)
                            }
                        }
                        break
                    } else {
                        stringBuilder.append(char1)
                    }
                }
            } else {
                strStack.push(char)
            }
        }
        return strStack.joinToString(separator = "")
    }

    //LeetCode solution
    //Duration: 3ms
    //Time complexity: O(n)
    //Space complexity: O(n)
    fun decodeStringLeetCode(s: String): String {
        var i = 0
        fun parse(): String {
            var currRepeat = 0
            val currString = StringBuilder()
            while (i < s.length) {
                if (s[i] in '0'..'9') {
                    currRepeat = (currRepeat * 10) + (s[i] - '0')
                    i++
                } else if (s[i] == '[') {
                    i++
                    val curr = parse()
                    repeat(currRepeat) {
                        currString.append(curr)
                    }
                    currRepeat = 0
                } else if (s[i] == ']') {
                    i++
                    return currString.toString()
                } else {
                    currString.append(s[i])
                    i++
                }
            }
            return currString.toString()
        }
        return parse()
    }

    //Copilot solution
    //Duration: 7ms
    //Time complexity: O(n)
    //Space complexity: O(n)
    fun decodeStringCopilot(s: String): String {
        val stack = Stack<String>()
        var currentNum = 0
        var currentString = StringBuilder()

        for (char in s) {
            when {
                char.isDigit() -> {
                    currentNum = currentNum * 10 + (char - '0')
                }

                char == '[' -> {
                    stack.push(currentString.toString())
                    stack.push(currentNum.toString())
                    currentString = StringBuilder()
                    currentNum = 0
                }

                char == ']' -> {
                    val num = stack.pop().toInt()
                    val prevString = stack.pop()
                    currentString = StringBuilder(prevString + currentString.toString().repeat(num))
                }

                else -> {
                    currentString.append(char)
                }
            }
        }

        return currentString.toString()
    }


}