package com.example.leetcode75

/**
 * 2215. Find the Difference of Two Arrays
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,3], nums2 = [2,4,6]
 * Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].
 *
 * Example 2:
 * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * Output: [[3],[]]
 * Explanation:
 * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
 * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * -1000 <= nums1[i], nums2[i] <= 1000
 */
class Problem2215 {
    //My solution
    //Duration 10ms
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val map1 = HashMap<Int, Int>()
        val map2 = HashMap<Int, Int>()
        for (i in nums1.indices) {
            if (map1[nums1[i]] == null) {
                map1[nums1[i]] = 1
            }
        }
        for (i in nums2.indices) {
            if (map1[nums2[i]] == null) {
                map2[nums2[i]] = 1
            } else {
                map1[nums2[i]] = 2
                map2[nums2[i]] = 2
            }
        }
        val list1 = map1.keys.filter { map1[it] == 1 }
        val list2 = map2.keys.filter { map2[it] == 1 }
        return listOf(list1, list2)
    }

    //LeetCode's solution
    // Set.contains has time complexity = O(1)
    // Duration = 1ms
    fun findDifferenceLeetCode(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val first = HashSet<Int>()
        val second = HashSet<Int>()

        val missing1 = ArrayList<Int>()
        val missing2 = ArrayList<Int>()

        for (element in nums1) {
            first.add(element)
        }

        for (element in nums2) {
            second.add(element)
        }

        first.forEach { num ->
            if (!second.contains(num)) {
                missing1.add(num)
            }
        }

        second.forEach { num ->
            if (!first.contains(num)) {
                missing2.add(num)
            }
        }

        val result = ArrayList<ArrayList<Int>>()
        result.add(missing1)
        result.add(missing2)

        return result
    }

    //Copilot solution
    //Duration = 15ms
    fun findDifferenceCopilot(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()

        val diff1 = set1.subtract(set2).toList()
        val diff2 = set2.subtract(set1).toList()

        return listOf(diff1, diff2)
    }
}