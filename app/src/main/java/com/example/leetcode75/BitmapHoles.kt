package com.example.leetcode75

/**
 * Bitmap Holes
 * Have the function BitmapHoles(strArr) take the array of strings stored in strArr, which will be a 2D matrix of 0 and 1's, and determine how many holes, or contiguous regions of 0's, exist in the matrix. A contiguous region is one where there is a connected group of 0's going in one or more of four directions: up, down, left, or right. For example: if strArr is ["10111", "10101", "11101", "11111"], then this looks like the following matrix:
 *
 * 1 0 1 1 1
 * 1 0 1 0 1
 * 1 1 1 0 1
 * 1 1 1 1 1
 *
 * For the input above, your program should return 2 because there are two separate contiguous regions of 0's, which create "holes" in the matrix. You can assume the input will not be empty.
 * Examples
 * Input: arrayOf("01111", "01101", "00011", "11110")
 * Output: 3
 * Input: arrayOf("1011", "0010")
 * Output: 2
 */
class BitmapHoles {
    fun bitmapHoles(strArr: Array<String>): Int {
        val numRows = strArr.size
        val numCols = strArr[0].length
        val visited = Array(numRows) { BooleanArray(numCols) }
        var holeCount = 0

        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                if (strArr[i][j] == '0' && !visited[i][j]) {
                    holeCount++
                    markVisited(strArr, visited, i, j, numRows, numCols)
                }
            }
        }
        return holeCount
    }

    private fun markVisited(
        strArr: Array<String>,
        visited: Array<BooleanArray>,
        row: Int,
        col: Int,
        numRows: Int,
        numCols: Int
    ) {
        if (row < 0 || col < 0 || row >= numRows || col >= numCols) return
        if (strArr[row][col] == '1' || visited[row][col]) return

        visited[row][col] = true

        markVisited(strArr, visited, row + 1, col, numRows, numCols)
        markVisited(strArr, visited, row - 1, col, numRows, numCols)
        markVisited(strArr, visited, row, col + 1, numRows, numCols)
        markVisited(strArr, visited, row, col - 1, numRows, numCols)
    }
}