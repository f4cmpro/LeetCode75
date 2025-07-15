package com.example.leetcode75

/**
 * 151. Reverse Words in a String
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 *
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
class Problem151 {
    // Code of me - 16ms - through arr multiple time -> time complete large
    fun reverseWords(s: String): String {
        val newS = removeExtraSpaces(s)
        val strArr = newS.split(" ").toTypedArray()
        var left = 0
        var right = strArr.lastIndex
        while (left < right) {
            val temp = strArr[left]
            strArr[left] = strArr[right]
            strArr[right] = temp
            left++
            right--
        }
        return strArr.joinToString(" ")
    }

    private fun removeExtraSpaces(s: String): String {
        return s.trim().replace(Regex("\\s+"), " ")
    }


    //Code example - 1ms - through arr 1 time
//    fun reverseWords(s: String): String {
//        val charArray = s.toCharArray()
//        reverseString(charArray, 0, charArray.size - 1)
//
//        val n = s.length
//        var i = 0
//        var l = 0
//        var r = 0
//
//        while (i < n) {
//            while (i < n && charArray[i] == ' ') {
//                i++
//            }
//
//            l = r
//            while (i < n && charArray[i] != ' ') {
//                charArray[r++] = charArray[i++]
//            }
//
//            if (l < r) {
//                reverseString(charArray, l, r - 1)
//                if (r < n) {
//                    charArray[r++] = ' '
//                }
//            }
//        }
//
//        if (r > 0 && charArray[r - 1] == ' ') {
//            r--
//        }
//
//        return String(charArray, 0, r)
//    }
//
//    private fun reverseString(s: CharArray, left: Int, right: Int): CharArray {
//        var i = left
//        var j = right
//        while (i < j) {
//            val tmp = s[i]
//            s[i++] = s[j]
//            s[j--] = tmp
//        }
//        return s
//    }
}