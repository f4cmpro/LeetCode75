package com.example.leetcode75;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Medium
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * <p>
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * <p>
 * Example 2:
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * <p>
 * Example 3:
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
class Problem1456 {
    fun maxVowels(s: String, k: Int): Int {
        var max = 0
        val sub = s.substring(0, k)
        for (i in sub.indices) {
            if (isVowel(sub[i])) {
                max++
            }
        }
        var count = max
        for (i in k until s.length) {
            if (isVowel(s[i - k])) {
                count--
            }
            if (isVowel(s[i])) {
                count++
            }
            if (count > max) {
                max = count
            }
        }
        return max
    }

    private fun isVowel(char: Char): Boolean {
        return char == 'u' || char == 'e' || char == 'o' || char == 'a' || char == 'i'
    }
}
