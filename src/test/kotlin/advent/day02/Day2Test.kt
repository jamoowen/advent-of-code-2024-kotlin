package advent.day02

import advent.random.squarePositiveNumOnly

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import arrow.core.*

class Day2Test {

    @Test
    fun `checkReport should return true if list is descending`() {
        val testList = listOf(7, 6, 4, 2, 1)
        val result = checkReport(testList)
        assertTrue(result)
    }

    @Test
    fun `checkReport should return true if list is ascending`() {
        val testList = listOf(3, 5, 6, 7, 9)
        val result = checkReport(testList)
        assertTrue(result)
    }

    @Test
    fun `checkReport should return false if list is has diffs larger than 2`() {
        val testList = listOf(3, 5, 6, 7, 9, 13)
        val result = checkReport(testList)
        assertFalse(result)
    }

    @Test
    fun `checkReport should return false if list is has diffs == 0`() {
        val testList = listOf(3, 5, 6, 7, 9, 9)
        val result = checkReport(testList)
        assertFalse(result)
    }

    @Test
    fun `checkReport should return expected results for multiple cases`() {
        val testCases = listOf(
            listOf(7, 6, 4, 2, 1) to true,  // Safe: All decreasing by 1 or 2
            listOf(1, 2, 7, 8, 9) to false, // Unsafe: 2 → 7 is an increase of 5
            listOf(9, 7, 6, 2, 1) to false, // Unsafe: 6 → 2 is a decrease of 4
            listOf(1, 3, 2, 4, 5) to false, // Unsafe: Direction changes (1→3 up, 3→2 down)
            listOf(8, 6, 4, 4, 1) to false, // Unsafe: 4 → 4 has no change
            listOf(1, 3, 6, 7, 9) to true   // Safe: All increasing by 1, 2, or 3
        )
        testCases.forEach { (input, expected) ->
            assertEquals(expected, checkReport(input), "Failed for input: $input")
        }
    }

    @Test
    fun `checkReportWithDampener should return expected results for multiple cases`() {
        val testCases = listOf(
            listOf(7, 6, 4, 2, 1) to true,  // Safe: All decreasing by 1 or 2
            listOf(1, 2, 7, 8, 9) to false, // Unsafe: 2 → 7 is an increase of 5
            listOf(9, 7, 6, 2, 1) to false, // Unsafe: 6 → 2 is a decrease of 4
            listOf(1, 3, 2, 4, 5) to true, // Unsafe: Direction changes (1→3 up, 3→2 down)
            listOf(8, 6, 4, 4, 1) to true, // Unsafe: 4 → 4 has no change
            listOf(1, 3, 6, 7, 9) to true   // Safe: All increasing by 1, 2, or 3
        )
        testCases.forEach { (input, expected) ->
            assertEquals(expected, checkReportWithDampener(input), "Failed for input: $input")
        }
    }


}