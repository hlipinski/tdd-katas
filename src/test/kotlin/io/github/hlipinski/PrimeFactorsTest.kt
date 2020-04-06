package io.github.hlipinski

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrimeFactorsTest {

    /*
    1 => []
    2 => [2]
    3 => [3]
    4 => [2, 2]
    5 => [5]
    6 => [2, 3]
    7 => [7]
    8 => [2, 2, 2]
    9 => [3, 3]
    ...
    4620 => [2, 2, 3, 5, 7, 11]
     */

    private val factors = PrimeFactors()

    @Test
    fun `should return no factors for 1`() {
        assertThat(factors.generate(1)).isEmpty()
    }

    @Test
    fun `should return correct result for 2`() {
        assertThat(factors.generate(2)).isEqualTo(listOf(2))
    }

    @Test
    fun `should return correct result for 3`() {
        assertThat(factors.generate(3)).isEqualTo(listOf(3))
    }

    @Test
    fun `should return correct result for 4`() {
        assertThat(factors.generate(4)).isEqualTo(listOf(2, 2))
    }

    @Test
    fun `should return correct result for 5`() {
        assertThat(factors.generate(5)).isEqualTo(listOf(5))
    }

    @Test
    fun `should return correct result for 6`() {
        assertThat(factors.generate(6)).isEqualTo(listOf(2, 3))
    }

    @Test
    fun `should return correct result for 7`() {
        assertThat(factors.generate(7)).isEqualTo(listOf(7))
    }

    @Test
    fun `should return correct result for 8`() {
        assertThat(factors.generate(8)).isEqualTo(listOf(2, 2, 2))
    }

    @Test
    fun `should return correct result for 9`() {
        assertThat(factors.generate(9)).isEqualTo(listOf(3, 3))
    }

    @Test
    fun `should return correct result for 4620`() {
        assertThat(factors.generate(4620)).isEqualTo(listOf(2, 2, 3, 5, 7, 11))
    }
}