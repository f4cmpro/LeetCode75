package com.example.leetcode75

/**
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
class Problem238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answers = IntArray(size = nums.size)
        val pre = IntArray(size = nums.size)
        val suf = IntArray(size = nums.size)
        for (i in pre.indices) {
            if (i == 0) {
                pre[i] = 1
            } else {
                pre[i] = pre[i - 1] * nums[i - 1]
            }
        }
        for (i in suf.lastIndex downTo 0) {
            if (i == suf.lastIndex) {
                suf[i] = 1
            } else {
                suf[i] = suf[i + 1] * nums[i + 1]
            }
        }
        for (i in answers.indices) {
            answers[i] = pre[i] * suf[i]
        }
        return answers
    }

//    fun productExceptSelf(nums: IntArray): IntArray {
//        val size = nums.size
//        val result = IntArray(nums.size)
//        // Prefix Product
//        var prod = 1
//        for (i in 0 until size) {
//            result[i] = prod
//            prod *= nums[i]
//        }
//        // Sufix Product
//        prod = 1
//        for (i in size-1 downTo 0) {
//            result[i] = prod * result[i]
//            prod *= nums[i]
//        }
//        return result
//    }
}