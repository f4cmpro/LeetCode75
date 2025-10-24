package com.example.leetcode75

/**
 *
 * Have the function OptimalAssignments(strArr) read strArr which will represent an NxN matrix and
 * it will be in the following format: ["(n,n,n...)","(...)",...] where the n's represent integers.
 * This matrix represents a machine at row i performing task at column j. The cost for this is matrix[i][j].
 * Your program should determine what machine should perform what task so as to minimize the whole cost and
 * it should return the pairings of machines to tasks in the following format: (i-j)(...)...
 * Only one machine can perform one task. For example: if strArr is ["(5,4,2)","(12,4,3)","(3,4,13)"]
 * then your program should return (1-3)(2-2)(3-1) because assigning the machines to these tasks gives the least cost.
 * The matrix will range from 2x2 to 6x6, there will be no negative costs in the matrix, and there will always be a unique answer.
 * Examples
 * Input: arrayOf("(1,2,1)","(4,1,5)","(5,2,1)")
 * Output: (1-1)(2-2)(3-3)
 * Input: arrayOf("(13,4,7,6)","(1,11,5,4)","(6,7,2,8)","(1,3,5,9)")
 * Output: (1-2)(2-4)(3-3)(4-1)
 */
class OptimalAssignments {
    fun optimalAssignments(strArr: Array<String>): String {
        val n = strArr.size
        val costMatrix = Array(n) { IntArray(n) }
        for (i in strArr.indices) {
            val row = strArr[i].removeSurrounding("(", ")").split(",").map { it.toInt() }
            for (j in row.indices) {
                costMatrix[i][j] = row[j]
            }
        }

        val assignedTasks = BooleanArray(n)
        val result = mutableListOf<Pair<Int, Int>>()

        fun findNextAssignment(machine: Int, currentCost: Int) {
            if (machine == n) {
                return
            }
            var minCost = Int.MAX_VALUE
            var bestTask = -1
            for (task in 0 until n) {
                if (!assignedTasks[task]) {
                    val totalCost = currentCost + costMatrix[machine][task]
                    if (totalCost < minCost) {
                        minCost = totalCost
                        bestTask = task
                    }
                }
            }
            if (bestTask != -1) {
                assignedTasks[bestTask] = true
                result.add(Pair(machine + 1, bestTask + 1))
                findNextAssignment(machine + 1, minCost)
            }
        }

        findNextAssignment(0, 0)

        return result.joinToString("") { "(${it.first}-${it.second})" }
    }
}