package com.example.leetcode75

class ParallelSums {
    fun parallelSums(arr: Array<Int>): String {
        val arrSum = arr.sum()
        if (arrSum % 2 != 0) return "-1"

        val halfSum = arrSum / 2
        val n = arr.size
        val dp = Array(n + 1) { BooleanArray(halfSum + 1) }
        dp[0][0] = true

        for (i in 1..n) {
            for (j in 0..halfSum) {
                dp[i][j] = dp[i - 1][j]
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]]
                }
            }
        }

        if (!dp[n][halfSum]) return "-1"

        val set1 = mutableListOf<Int>()
        val set2 = mutableListOf<Int>()
        var w = halfSum
        for (i in n downTo 1) {
            if (!dp[i - 1][w]) {
                set1.add(arr[i - 1])
                w -= arr[i - 1]
            } else {
                set2.add(arr[i - 1])
            }
        }

        set1.sort()
        set2.sort()
        return if (set1.first() < set2.first()) {
            (set1 + set2).joinToString(",")
        } else {
            (set2 + set1).joinToString(",")
        }
    }
}