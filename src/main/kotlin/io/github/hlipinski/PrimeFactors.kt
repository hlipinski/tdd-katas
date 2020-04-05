package io.github.hlipinski

class PrimeFactors {
    fun generate(number: Int, accumulator: List<Int> = emptyList()): List<Int> =
        when (number) {
            1 -> accumulator
            2 -> accumulator + listOf(2)
            3 -> accumulator + listOf(3)
            else -> {
                val divider = (2 .. number / 2).firstOrNull { number % it == 0 }
                if (divider == null) accumulator + number
                else generate(number / divider, accumulator + divider)
            }
        }
}
