package com.example.leetcode75

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * Follow up: Could you minimize the total number of operations done?
 */
class Problem283 {
    //tc = 22ms beats 14.14%, sc = 49.39mb beats 92.82%
//    fun moveZeroes(nums: IntArray): Unit {
//        var curr = nums.size - 1
//        var repIndex = curr
//        while (curr >= 0) {
//            if (nums[curr] == 0) {
//                for (i in curr until repIndex) {
//                    nums[i] = nums[i + 1]
//                }
//                nums[repIndex] = 0
//                repIndex--
//            }
//            curr--
//        }
//    }
    // tc = 1ms - Operations: sub optimal
//    fun moveZeroes(nums: IntArray): Unit {
//        val n = nums.size
//        var s = 0
//        var f = 0
//        while(f < n) {
//            if(nums[f] != 0) {
//                nums[s] = nums[f]
//                s += 1
//            }
//            f += 1
//        }
//
//        for(i in s until n) {
//            nums[i] = 0
//        }
//    }

    //Operations: Best Optimal
    fun moveZeroes(nums: IntArray): Unit {
        var lastNonZeroFoundAt = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                //exception: if nums[i] == nums[lastNonZeroFoundAt] -> results: 0 -> wrong
//                nums[i] = nums[i].xor(nums[lastNonZeroFoundAt])
//                nums[lastNonZeroFoundAt] = nums[i].xor(nums[lastNonZeroFoundAt])
//                nums[i] = nums[i].xor(nums[lastNonZeroFoundAt])
                val temp = nums[i]
                nums[i] = nums[lastNonZeroFoundAt]
                nums[lastNonZeroFoundAt] = temp
                lastNonZeroFoundAt++
            }
        }
    }
}