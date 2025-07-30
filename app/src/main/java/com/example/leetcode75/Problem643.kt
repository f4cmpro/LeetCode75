package com.example.leetcode75

import kotlin.math.roundToLong

/**
 * 643. Maximum Average Subarray I
 * Easy
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 * Constraints:
 * n == nums.length
 * 1 <= k <= n <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
class Problem643 {

    // My Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
//    fun findMaxAverage(nums: IntArray, k: Int): Double {
//        var sum = nums.slice(0 until k).sum()
//        var max = "%.5f".format(sum.toDouble() / k).toDouble()
//        for (i in k until nums.size) {
//            sum = sum - nums[i - k] + nums[i]
//            val average = "%.5f".format(sum.toDouble() / k).toDouble()
//            if (max < average) {
//                max = average
//            }
//        }
//        return max
//    }

    // LeetCode Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
//    fun findMaxAverage(nums: IntArray, k: Int): Double {
//        var windowsum = 0
//
//        for(i in 0 until k)
//        {
//            windowsum += nums[i]
//        }
//
//        var maxsum = windowsum
//
//        for(i in k until nums.size)
//        {
//            windowsum = windowsum - nums[i-k] + nums[i]
//
//            if(windowsum > maxsum)
//            {
//                maxsum = windowsum
//            }
//        }
//
//        return maxsum.toDouble() / k
//    }
}