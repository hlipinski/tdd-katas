package io.github.hlipinski

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

internal class FuzzBuzzConverterTest {

    /*
    1 => 1
    2 => 2
    3 => Fuzz
    4 => 4
    5 => Buzz
    ...
    15 => FuzzBuzz
     */

    private val converter = FuzzBuzzConverter()

    @Test
    fun `should return numbers strict`() {
        assertThat(converter.convert(1)).isEqualTo("1")
        assertThat(converter.convert(2)).isEqualTo("2")
    }

    @Test
    fun `should return Fuzz for numbers % 3`() {
        assertThat(converter.convert(3)).isEqualTo("Fuzz")
        assertThat(converter.convert(6)).isEqualTo("Fuzz")
    }

    @Test
    fun `should return Buzz for numbers % 5`() {
        assertThat(converter.convert(5)).isEqualTo("Buzz")
        assertThat(converter.convert(10)).isEqualTo("Buzz")
    }

    @Test
    fun `should return FuzzBuzz for numbers % 3 and % 5`() {
        assertThat(converter.convert(15)).isEqualTo("FuzzBuzz")
        assertThat(converter.convert(90)).isEqualTo("FuzzBuzz")
    }
}