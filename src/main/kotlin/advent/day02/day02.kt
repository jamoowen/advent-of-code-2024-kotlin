package advent.day02

import advent.utils.InputReader
import arrow.core.*
import kotlin.math.absoluteValue

// FOR THE REPORTS TO BE SAFE:
//The levels are either all increasing or all decreasing.
//Any two adjacent levels differ by at least one and at most three.

//7 6 4 2 1
//25 31 32 35 37 36 37 37
//47 54 51 54 58
//33 40 41 40 42 49
//47 52 55 58 58 60

fun checkReport(report: List<Int>): Boolean {
    if (report.size < 2) return false
    //
    val direction = report[0].compareTo(report[1])
    if (direction == 0) return false
    for (i in 0..<report.size - 1) {
        val diff = report[i].minus(report[i + 1])
        val tempDirection = report[i].compareTo(report[i + 1])
        if (tempDirection != direction || diff.absoluteValue > 3) return false
    }
    return true
}

fun checkReportWithDampener(report: List<Int>): Boolean {
    // first run it through checkReport
    if (checkReport(report)) return true
    //else we need to loop through the reports, removing a char each time
    for (i in report.indices) {
        val dampenedReport = report.toMutableList()
        dampenedReport.removeAt(i)
        if (checkReport(dampenedReport)) return true
    }
    return false
}

fun determineValidReports(allReports: List<String>, checkFunction: (List<Int>) -> Boolean): Int {
    return allReports.fold(0) { acc, line ->
        val report = line.split(" ").map { it.toInt() }
        if (checkFunction(report)) acc.plus(1) else acc
    }
}

fun main(args: Array<String>) {
    val allReports = InputReader.readLinesForDay("day02").getOrElse { err ->
        println("Error reading file: $err")
        return
    }
    val checkForSolution1 = ::checkReport

    val solution1 = determineValidReports(allReports, checkForSolution1)
    val solution2 = determineValidReports(allReports, ::checkReportWithDampener)

    println("Solution 1: $solution1")
    println("Solution 2: $solution2")

}