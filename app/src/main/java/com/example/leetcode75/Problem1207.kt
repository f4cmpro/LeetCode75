package com.example.leetcode75

/**
 * 1207. Unique Number of Occurrences
 * Easy
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 * Example 1:
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 *
 * Example 2:
 * Input: arr = [1,2]
 * Output: false
 *
 * Example 3:
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 * Constraints:
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
class Problem1207 {
    // My Solution
    // Running time: 1-3ms, TC = O(n), SC = O(n)
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val uniqueOccurrencesMap = HashMap<Int, Int>()
        val amountOfOccurrencesSet = HashSet<Int>()
        for (i in arr.indices) {
            val key = arr[i]
            val amount = uniqueOccurrencesMap[key]
            if (amount != null) {
                uniqueOccurrencesMap[key] = amount + 1
            } else {
                uniqueOccurrencesMap[key] = 1
            }
        }
        uniqueOccurrencesMap.values.forEach {
            if (amountOfOccurrencesSet.contains(it)) {
                return false
            } else {
                amountOfOccurrencesSet.add(it)
            }
        }
        return true
    }

    // LeetCode Solution
    // Running time: 1-3ms, TC = O(n), SC = O(n)
    fun uniqueOccurrencesLeetCode(arr: IntArray): Boolean {
        val occurance = IntArray(2001)

        for (num in arr) {
            occurance[num + 1000]++
        }

        val uniqueNums: MutableSet<Int> = HashSet<Int>()
        for (num in arr) {
            val count = occurance[num + 1000]
            if (count != 0) {
                if (uniqueNums.contains(count)) {
                    return false
                } else {
                    uniqueNums.add(count)
                    occurance[num + 1000] = 0
                }
            }
        }

        return true
    }

    // Copilot Solution
    // Running time: 1-3ms, TC = O(n), SC = O
    fun uniqueOccurrencesCopilot(arr: IntArray): Boolean {
        val countMap = mutableMapOf<Int, Int>()
        for (num in arr) {
            countMap[num] = countMap.getOrDefault(num, 0) + 1
        }

        val occurrencesSet = mutableSetOf<Int>()
        for (count in countMap.values) {
            if (!occurrencesSet.add(count)) {
                return false
            }
        }
        return true
    }
}