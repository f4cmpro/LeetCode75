package com.example.leetcode75

import java.util.Stack
import kotlin.math.abs

/**
 * 735. Asteroid Collision
 * Medium
 * You are given an array of integers asteroids representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 *
 * Example 2:
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 *
 * Example 3:
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 *
 * Constraints:
 *
 * 2 <= asteroids.length <= 10^4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
class Problem735 {
    //My solution
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val strongestAsteroidStack = Stack<Int>()
        for (asteroid in asteroids) {
            if (strongestAsteroidStack.empty()) {
                strongestAsteroidStack.push(asteroid)
            } else {
                while (true) {
                    val lastStrongAsteroid = strongestAsteroidStack.last()
                    if (lastStrongAsteroid * asteroid > 0 || (lastStrongAsteroid < 0 && asteroid > 0)) {
                        strongestAsteroidStack.push(asteroid)
                        break
                    } else {
                        if (abs(lastStrongAsteroid) < abs(asteroid)) {
                            strongestAsteroidStack.pop()
                            if (strongestAsteroidStack.empty()) {
                                strongestAsteroidStack.push(asteroid)
                                break
                            }
                        } else if (abs(lastStrongAsteroid) > abs(asteroid)) {
                            break
                        } else {
                            strongestAsteroidStack.pop()
                            break
                        }
                    }
                }

            }
        }
        return strongestAsteroidStack.toIntArray()
    }

    //LeetCode
    fun asteroidCollisionLeetCode(asteroids: IntArray): IntArray {
        val stack = java.util.ArrayDeque<Int>()
        var i = 0
        while (i < asteroids.size) {
            val asteriod = asteroids[i]
            if (asteriod > 0) {
                stack.addLast(asteriod)
                i++
            } else if (asteriod < 0) {
                // check collisions
                val lastAsteroid = stack.peekLast()
                if (lastAsteroid != null && lastAsteroid > 0) {
                    if (lastAsteroid > Math.abs(asteriod)) {
                        i++
                    } else if (lastAsteroid < Math.abs(asteriod)) {
                        stack.removeLast()
                    } else {
                        stack.removeLast()
                        i++
                    }
                } else {
                    asteriod?.let {
                        stack.addLast(it)
                    }
                    i++
                }
            }
        }
        val result = IntArray(stack.size)
        for (i in 0..stack.size - 1) {
            result[i] = stack.removeFirst()
        }
        return result
    }

    //Copilot
    fun asteroidCollisionCopilot(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (asteroid in asteroids) {
            var currentAsteroid = asteroid
            while (stack.isNotEmpty() && stack.peek() > 0 && currentAsteroid < 0) {
                val topAsteroid = stack.peek()
                if (topAsteroid < -currentAsteroid) {
                    stack.pop()
                } else if (topAsteroid == -currentAsteroid) {
                    stack.pop()
                    currentAsteroid = 0
                } else {
                    currentAsteroid = 0
                }
            }
            if (currentAsteroid != 0) {
                stack.push(currentAsteroid)
            }
        }
        return stack.toIntArray()
    }
}