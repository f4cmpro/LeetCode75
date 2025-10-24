package com.example.leetcode75

/**
 * Roman Numeral Reduction
 * Have the function RomanNumeralReduction(str) read str which will be a string of roman numerals in decreasing order.
 * The numerals being used are: I for 1, V for 5, X for 10, L for 50, C for 100, D for 500 and M for 1000.
 * Your program should return the same number given by str using a smaller set of roman numerals.
 * For example: if str is "LLLXXXVVVV" this is 200, so your program should return CC
 * because this is the shortest way to write 200 using the roman numeral system given above.
 * If a string is given in its shortest form, just return that same string.
 */
class RomanNumeralReduction {
    fun romanNumeralReduction(str: String): String {
        val romanToInt = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        val intToRoman = listOf(
            Pair(1000, "M"),
            Pair(900, "CM"),
            Pair(500, "D"),
            Pair(400, "CD"),
            Pair(100, "C"),
            Pair(90, "XC"),
            Pair(50, "L"),
            Pair(40, "XL"),
            Pair(10, "X"),
            Pair(9, "IX"),
            Pair(5, "V"),
            Pair(4, "IV"),
            Pair(1, "I")
        )

        // Convert Roman numeral string to integer
        var total = 0
        for (char in str) {
            total += romanToInt[char] ?: 0
        }

        // Convert integer back to minimal Roman numeral string
        val result = StringBuilder()
        var remainder = total
        for ((value, symbol) in intToRoman) {
            while (remainder >= value) {
                result.append(symbol)
                remainder -= value
            }
        }

        return result.toString()
    }
}