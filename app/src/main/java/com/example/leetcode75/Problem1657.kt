package com.example.leetcode75

/**
 * 1657. Determine if Two Strings Are Close
 * Medium
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 10^5
 * word1 and word2 contain only lowercase English letters.
 */
class Problem1657 {
    //My solution
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false
        val charMap1 = HashMap<Char, Int>()
        val charMap2 = HashMap<Char, Int>()
        for (i in word1.indices) {
            val char = word1[i]
            charMap1[char] = charMap1[char]?.plus(1) ?: 1
        }
        for (i in word2.indices) {
            val char = word2[i]
            charMap2[char] = charMap2[char]?.plus(1) ?: 1
        }
        val countMap1 = HashMap<Int, Int>()
        val countMap2 = HashMap<Int, Int>()
        for (i in charMap1) {
            if (!charMap2.values.contains(i.value)) {
                return false
            }
            if (!charMap2.keys.contains(i.key)) {
                return false
            }
            countMap1[i.value] = countMap1[i.value]?.plus(1) ?: 1
        }

        for (i in charMap2) {
            if (!charMap1.values.contains(i.value)) {
                return false
            }
            if (!charMap1.keys.contains(i.key)) {
                return false
            }
            countMap2[i.value] = countMap2[i.value]?.plus(1) ?: 1
        }

        for (i in countMap1.keys) {
            if (countMap1[i] != countMap2[i]) return false
        }

        return true
    }

    //LeetCode solution
    //Leet Code solution
    //Time: O(n + 26 log 26) ≈ O(n), Space: O(1)
    fun closeStringsLeetCode(word1: String, word2: String): Boolean {
        // find the count map of the words
        // compare the characters in the maps

        val word1_count = getCount(word1)
        val word2_count = getCount(word2)
        return areEqual(word1_count, word2_count)
    }

    private fun getCount(word: String): IntArray {
        val char_length = IntArray(26){0}
        for (index in 0 .. (word.length - 1)) {
            char_length[word[index] - 'a'] += 1
        }
        return char_length
    }

    private fun areEqual(word1: IntArray, word2: IntArray): Boolean {
        // first check if the zero counts match
        for (index in 0 .. 25) {
            if ((word1[index] == 0 && word2[index] != 0) || (word1[index] != 0 && word2[index] == 0)) {
                // one of the characters doesnt exist in other
                return false
            }
        }

        val word1_map = convertToMap(word1)
        val word2_map = convertToMap(word2)
        return word1_map == word2_map
    }

    private fun convertToMap(word: IntArray): Map<Int, Int> {
        val word_map = HashMap<Int, Int>()
        loop@for(index in 0 .. (word.size - 1)) {
            if (word[index] == 0) {
                // no character found since length is 0
                continue@loop
            }
            val count = word_map.get(word[index]) ?: 0
            word_map.put(word[index], (count + 1))
        }
        return word_map
    }

    //Copilot solution
    //Time: O(n + 26 log 26) ≈ O(n), Space: O(1)
    fun closeStringsCopilot(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val count1 = IntArray(26)
        val count2 = IntArray(26)

        for (i in word1.indices) {
            count1[word1[i] - 'a']++
            count2[word2[i] - 'a']++
        }

        for (i in 0 until 26) {
            if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0)) {
                return false
            }
        }

        count1.sort()
        count2.sort()

        return count1.contentEquals(count2)
    }
}