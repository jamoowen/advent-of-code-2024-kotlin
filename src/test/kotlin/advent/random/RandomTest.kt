package advent.random

import advent.utils.InputReader
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import arrow.core.*

class RandomTest {

    @Test
    fun `squarePositiveNumOnly should return squared value for positive numbers`() {
        val result = squarePositiveNumOnly(5)
        assertTrue(result is Either.Right)
        assertEquals(25, (result as Either.Right).value)
    }

    @Test
    fun `squarePositiveNumOnly should return an exception for negative numbers`() {
        val result = squarePositiveNumOnly(-5)
        assertTrue(result is Either.Left)
        assertEquals("Number is negative", (result as Either.Left).value.message)
    }

    @Test
    fun `squarePositiveNumOnly should return an exception for zero`() {
        val result = squarePositiveNumOnly(0)
        assertTrue(result is Either.Left)
        assertEquals("Number is zero", (result as Either.Left).value.message)
    }

    @Test
    fun `readLinesForDay should return left if file doesn't exist`() {
        val result = InputReader.readLinesForDay("nonexistent")
        assertTrue(result.isLeft())
        assertEquals("File for day nonexistent does not exist", (result as Either.Left).value.message)
    }

    @Test
    fun `readLinesForDay should return right with file contents if file exists`() {
        // Assuming the file "input/day01.txt" exists and contains some lines
        val result = InputReader.readLinesForDay("day01")
        assertTrue(result.isRight())
        assertTrue((result as Either.Right).value.isNotEmpty())
    }

    @Test
    fun `going from list to mutable list allows you to remove an index`() {
        // Assuming the file "input/day01.txt" exists and contains some lines
        val list1 = listOf("James", "aid", "roo")
        val list2 = list1.toMutableList()
        list2.removeAt(1)
        assertEquals(list1.size, 3)
        assertEquals(list2.size, 2)
        assertEquals(list2, mutableListOf("James","roo"))
    }
//    @Test
//    fun `this test should always fail`() {
//        val result = squarePositiveNumOnly(0)
//        assertTrue(result.isRight())
//    }
}
