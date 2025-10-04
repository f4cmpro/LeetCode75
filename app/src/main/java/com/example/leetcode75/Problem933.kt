package com.example.leetcode75

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

/**
 * 933. Number of Recent Calls
 * Easy
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 *
 * Implement the RecentCounter class:
 *
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 *
 *
 * Example 1:
 *
 * Input
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * Output
 * [null, 1, 2, 3, 3]
 *
 * Explanation
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
 * recentCounter.ping(100);   // requests = [1,100], range is [-2900,100], return 2
 * recentCounter.ping(3001);  // requests = [1,100,3001], range is [1,3001], return 3
 * recentCounter.ping(3002);  // requests = [1,100,3001,3002], range is [2,3002], return 3
 *
 *
 * Constraints:
 *
 * 1 <= t <= 10^9
 * Each test case will call ping with strictly increasing values of t.
 * At most 10^4 calls will be made to ping.
 */
class Problem933 {
    //My code
    //Duration: 12ms
    class RecentCounter {
        private val queue = LinkedList<Int>()
        fun ping(t: Int): Int {
            queue.offer(t)
            var prevCall = queue.peek()
            while (prevCall != null && prevCall < t - 3000) {
                queue.poll()
                prevCall = queue.peek()
            }
            return queue.size
        }
    }

    //LeetCode
    //Duration: 12ms
    class RecentCounterLeetCode() {
        private val list = ArrayList<Int>()
        fun ping(t: Int): Int {
            list.add(t)
            val s = list.size
            val ans = s - list.binarySearch(max(s - 3000 - 1, 0), s - 1, t - 3000)
            return ans
        }

        private fun ArrayList<Int>.binarySearch(left: Int, right: Int, value: Int): Int {
            val l = left
            val r = right
            val mid = (l + r) / 2
            return if (l >= r) r
            else if (this[mid] < value) this.binarySearch(mid + 1, r, value)
            else this.binarySearch(l, mid, value)

        }
    }

    //Copilot solution
    //Duration: 14ms
    class RecentCounterCopilot() {
        private val queue: Queue<Int> = LinkedList()
        fun ping(t: Int): Int {
            queue.add(t)
            while (queue.peek()!! < t - 3000) {
                queue.poll()
            }
            return queue.size
        }
    }

    fun countRequests(times: Array<IntArray>): List<Int?> {
        val output = mutableListOf<Int?>()
        output.add(null)
        val recentCounter = RecentCounterCopilot()
        for (i in 1 until times.size) {
            val t = times[i].first()
            val count = recentCounter.ping(t)
            output.add(count)
        }
        return output
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */