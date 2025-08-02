package com.example.leetcode75

import kotlin.math.max

/**
 * 1004. Max Consecutive Ones III
 * Medium
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */
class Problem1004 {
    // My Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun longestOnes(nums: IntArray, k: Int): Int {
        var max = 0
        var countOnes = 0
        var countZeros = 0
        val zerosIndexs = IntArray(nums.size)
        var currZeroIndex = 0
        var firstZeroIndex = 0
        for (i in nums.indices) {
            if (nums[i] == 1) {
                countOnes++
            } else {
                zerosIndexs[currZeroIndex] = i
                currZeroIndex++
                if (k == 0) {
                    countOnes = 0
                } else if (countZeros < k) {
                    countZeros++
                    countOnes++
                } else {
                    countOnes = i - zerosIndexs[firstZeroIndex]
                    firstZeroIndex++
                }
            }
            if (countOnes > max) {
                max = countOnes
            }
        }
        return max
    }

    // Copilot Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun longestOnesCopilot(nums: IntArray, k: Int): Int {
        var left = 0
        var right = 0
        var maxLength = 0
        var zeroCount = 0

        while (right < nums.size) {
            if (nums[right] == 0) {
                zeroCount++
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--
                }
                left++
            }

            maxLength = max(maxLength, right - left + 1)
            right++
        }

        return maxLength
    }

    // LeetCode Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun longestOnesLeetCode(nums: IntArray, k: Int): Int {
        var remain = k
        var l = 0
        for (element in nums) {
            if (element == 0) {
                remain--
            }

            if (remain < 0) {
                if (nums[l] == 0) {
                    remain++
                }
                l++
            }
        }

        return nums.size - l
    }
}