package com.example.leetcode75

import java.util.LinkedList
import java.util.Queue

/**
 * 649. Dota2 Senate
 * Medium
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 * The Dota2 senate consists of senators coming from two parties. Now the senate wants to make a decision about a change in the Dota2 game.
 * The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
 * Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
 * Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
 * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party respectively.
 * Then if there are n senators, the size of the given string will be n.
 * The round-based procedure starts from the first senator to the last senator in the given order.
 * This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 * Suppose every senator is smart enough and will play the best strategy for his own party.
 * Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
 *
 * Example 1:
 * Input: senate = "RD"
 * Output: "Radiant"
 * Explanation: The first senator comes from Radiant and he can just ban the next senator's right in round 1.
 * And the second senator can't exercise any rights anymore since his right has been banned.
 * And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
 *
 * Example 2:
 * Input: senate = "RDD"
 * Output: "Dire"
 * Explanation: The first senator comes from Radiant and he can just ban the next senator's right in round 1.
 * And the second senator can't exercise any rights anymore since his right has been banned.
 * And in round 2, the third senator can just ban the first senator's right since he is the only guy in the senate who can vote.
 * And in round 3, the third senator can just announce the victory since he is the only guy in the senate who can vote.
 *
 * Constraints:
 * n == senate.length
 * 1 <= n <= 10^4
 * senate[i] is either 'R' or 'D'.
 */
class Problem649 {
    fun predictPartyVictory(senate: String): String {
        val radiant = LinkedList<Int>()
        val dire = LinkedList<Int>()
        for (i in senate.indices) {
            if (senate[i] == 'R') {
                radiant.add(i)
            } else {
                dire.add(i)
            }
        }
        val n = senate.length
        while (radiant.isNotEmpty() && dire.isNotEmpty()) {
            val rIndex = radiant.poll()
            val dIndex = dire.poll()
            if (rIndex!! < dIndex!!) {
                radiant.add(rIndex + n)
            } else {
                dire.add(dIndex + n)
            }
        }
        return if (radiant.isNotEmpty()) "Radiant" else "Dire"
    }
}