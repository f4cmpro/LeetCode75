package com.example.leetcode75

/**
 * 11. Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
class Problem11 {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            val rectHeight = minOf(height[left], height[right])
            val rectWidth = right - left
            max = maxOf(max, rectWidth * rectHeight)
            if (height[left] > height[right]) {
                right--
            } else {
                left++
            }
        }
        return max
    }

//    fun maxArea(height: IntArray): Int {
//        var low = 0
//        var high = height.size - 1
//        var output = 0
//        var lowerHeight = 0
//
//        while (low < high) {
//            lowerHeight = minOf(height[low], height[high])
//            output = maxOf (
//                output,
//                lowerHeight * (high - low)
//            )
//            while (low < high && height[low] <= lowerHeight) {
//                low++
//            }
//            while (low < high && height[high] <= lowerHeight) {
//                high--
//            }
//        }
//
//        return output
//    }
}