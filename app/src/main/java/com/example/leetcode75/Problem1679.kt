package com.example.leetcode75

/**
 * 1679. Max Number of K-Sum Pairs
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 *
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^9
 */
class Problem1679 {
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()
        var operation = 0
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val sum = nums[left] + nums[right]
            if (sum == k) {
                operation++
                left++
                right--
            } else if (sum < k) {
                left++
            } else {
                right--
            }
        }
        return operation
    }

    //Write by Copilot
    // Time Complexity: O(n)
    // Space Complexity: O(n)
//    fun maxOperations(nums: IntArray, k: Int): Int {
//        val numCount = mutableMapOf<Int, Int>()
//        var operations = 0
//
//        for (num in nums) {
//            val complement = k - num
//            if (numCount.getOrDefault(complement, 0) > 0) {
//                operations++
//                numCount[complement] = numCount[complement]!! - 1
//            } else {
//                numCount[num] = numCount.getOrDefault(num, 0) + 1
//            }
//        }
//
//        return operations
//    }
}