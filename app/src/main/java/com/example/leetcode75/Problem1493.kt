package com.example.leetcode75

import kotlin.math.max

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 * Medium
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 * Example 1:
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 *
 * Example 2:
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 *
 * Example 3:
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 */
class Problem1493 {
    fun longestSubarray(nums: IntArray): Int {
        var left = 0
        var right = 0
        var maxLength = 0
        var delCount = 0

        while (right < nums.size) {
            if (nums[right] == 0) {
                delCount++
            }

            while (delCount > 1) {
                if (nums[left] == 0) {
                    delCount--
                }
                left++
            }

            maxLength = max(maxLength, right - left)
            right++
        }

        return maxLength
    }

    fun longestSubarrayMinSpaceComplexity(nums: IntArray): Int {
        var max = 0
        var left = mutableListOf<Int>()
        var count = 0
        nums.forEach {
            if (it != 0) count++
            else {
                left.add(count)
                count = 0
            }
        }
        count = 0
        val right = IntArray(left.size)
        var rightIndex = left.size - 1
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] != 0) count++
            else {
                right[rightIndex] = count
                rightIndex--
                count = 0
            }
        }
        left.forEachIndexed { index, it ->
            max = maxOf(max, it + right[index])
        }
        if (right.isEmpty()) return nums.size - 1
        return max
    }
}