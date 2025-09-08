package com.example.leetcode75

fun main() {
    val problem = Problem735()
    val asteroids = intArrayOf(1,-2,-2,-2)
    val start = System.currentTimeMillis()
    val answers = problem.asteroidCollisionCopilot(asteroids)
    val end = System.currentTimeMillis()
    print("Asteroid Collision: [")
    if (answers.isEmpty()) {
        println("]")
    }
    for (i in answers.indices) {
        if (i == answers.lastIndex) {
            println("${answers[i]}]")
        } else {
            print("${answers[i]}, ")
        }
    }
    println("Duration: ${end - start}ms")
}