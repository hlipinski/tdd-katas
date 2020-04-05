package io.github.hlipinski

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    /*
    "" => 0
    "0" => 0
    "1" => 1
    "1,2" => 3
    "1\n2" => 3
    "1,2,3" => 6
    "1,2\n3,4" => 10
    "-1,2,-3" => negatives not allowed: -1,-3
     */

    private val calculator = StringCalculator()

    @Test
    fun `should return zero when empty input`() {
        assertThat(calculator.calculate("")).isEqualTo("0")
        assertThat(calculator.calculate(" ")).isEqualTo("0")
    }

    @Test
    fun `should return int representation single input`() {
        assertThat(calculator.calculate("0")).isEqualTo("0")
        assertThat(calculator.calculate("1")).isEqualTo("1")
    }

    @Test
    fun `should return sum of 2 elements`() {
        assertThat(calculator.calculate("1,2")).isEqualTo("3")
        assertThat(calculator.calculate("1\n2")).isEqualTo("3")
    }

    @Test
    fun `should handle invalid arguments`() {
        assertThat(calculator.calculate("1,")).isEqualTo("1")
        assertThat(calculator.calculate(",1")).isEqualTo("1")
        assertThat(calculator.calculate("1\n")).isEqualTo("1")
        assertThat(calculator.calculate("\n1")).isEqualTo("1")
    }

    @Test
    fun `should return sum of 3 elements`() {
        assertThat(calculator.calculate("1,2,3")).isEqualTo("6")
        assertThat(calculator.calculate("1\n2\n3")).isEqualTo("6")
    }

    @Test
    fun `should return sum of 4 elements with mixed operators`() {
        assertThat(calculator.calculate("1,2\n3,4")).isEqualTo("10")
        assertThat(calculator.calculate("1\n2\n3,4")).isEqualTo("10")
    }

    @Test
    fun `should return error message when negative values given`() {
        assertThat(calculator.calculate("-1,2,-3")).isEqualTo("negatives not allowed: -1,-3")
    }
}