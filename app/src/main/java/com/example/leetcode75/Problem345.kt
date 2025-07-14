package com.example.leetcode75

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "IceCreAm"
 *
 * Output: "AceCreIm"
 *
 * Explanation:
 *
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 *
 * Output: "leotcede"
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
class Problem345 {
    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()
        var left = 0
        var right = chars.lastIndex
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++
            }
            while (right > left && !isVowel(chars[right])) {
                right--
            }
            if (left < right) {
                val temp = chars[left]
                chars[left] = chars[right]
                chars[right] = temp
                left++
                right--
            }
        }
        return chars.concatToString()
    }

    private fun isVowel(x: Char): Boolean {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ||
                x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U'
    }
}