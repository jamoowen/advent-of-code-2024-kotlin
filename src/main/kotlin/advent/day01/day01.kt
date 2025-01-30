package advent.day01

import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.math.absoluteValue


fun solvePart1(): Int {
    val unsortedListOfLocations = File("input/day01.txt").readLines()
    val listA: List<Int> = unsortedListOfLocations
        .map { it.split(" ").first().toInt() }
        .sorted()

    val listB: List<Int> = unsortedListOfLocations
        .map { it.split(" ").last().toInt() }
        .sorted()

    return listA.zip(listB)
        .sumOf { (first, second) -> (first - second).absoluteValue }
}


fun solvePart2(): Int {
    // how often each num from left list appears in right list
    // multiply it by the left list num
    // sum the results
    val unsortedListOfLocations = File("input/day01.txt").readLines()

    val frequencyDictB = unsortedListOfLocations
        .map { it.split(" ").last().toInt() }
        .groupingBy { it }.eachCount()


    val listA: List<Int> = unsortedListOfLocations
        .map { it.split(" ").first().toInt() }

    val listAWithSimilarityScore = listA.map {
        it.times(frequencyDictB[it] ?: 0)
    }

    val sumOfListASimilarityScores = listAWithSimilarityScore.sum()
    return sumOfListASimilarityScores

}

fun main() {
    val part2Solution = solvePart2()
    println("Part 2 Solution: $part2Solution")

}
