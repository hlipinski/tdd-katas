package io.github.hlipinski

class StringCalculator {
    fun calculate(s: String): String =
        when {
            s.isBlank() -> "0"
            s.matches(Regex("[0-9].*[,\n]")) -> "${s.toIntFromPos(0)}"
            s.matches(Regex("[\n,][0-9].*")) -> "${s.toIntFromPos(s.length - 1)}"
            s.contains(Regex("-")) ->
                "negatives not allowed: ${
                s.split(Regex("[,\n]"))
                    .filter { str -> str.contains("-") }
                    .reduce { a, b -> "$a,$b" }
                }"
            s.contains(Regex("[,\n]")) ->
                s.split(Regex("[,\n]"))
                    .reduce { a, b -> "${a.toInt() + b.toInt()}" }
            else -> "${s.toInt()}"
        }

    private fun String.toIntFromPos(pos: Int) = this[pos].toString().toInt()
}
