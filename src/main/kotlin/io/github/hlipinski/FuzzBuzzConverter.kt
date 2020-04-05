package io.github.hlipinski

class FuzzBuzzConverter {
    fun convert(i: Int): String? =
        when {
            i % 15 == 0 -> "FuzzBuzz"
            i % 3 == 0 -> "Fuzz"
            i % 5 == 0 -> "Buzz"
            else ->"$i"
        }
}
