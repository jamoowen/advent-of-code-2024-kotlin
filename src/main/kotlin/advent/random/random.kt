package advent.random
import arrow.core.*

fun squarePositiveNumOnly(n: Int): Either<Exception, Int> {
    return when {
        n < 0 -> Exception("Number is negative").left()
        n == 0 -> Exception("Number is zero").left()
        else -> (n * n).right()
    }
}
