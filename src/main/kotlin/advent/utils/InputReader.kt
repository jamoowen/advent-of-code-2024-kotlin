package advent.utils

import arrow.core.*
import java.io.File

object FileNotFound

class InputReader {

    companion object {
        private fun checkExists(day: String): Boolean {
            val file = File("input/$day.txt")
            return file.exists()
        }

        fun readLinesForDay(day: String): Either<Exception, List<String>> {
            if (!checkExists(day)) {
                return Exception("File for day $day does not exist").left()
            }
            try {
                val file = File("input/$day.txt").readLines()
                return file.right()
            } catch (e: Exception) {
                return e.left()
            }
        }
    }
}