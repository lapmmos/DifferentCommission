package ru.netology

import org.junit.jupiter.api.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun checkNull() {
        val inputValue = "100000"
        val result = checkNull(inputValue=inputValue)
        assertEquals(100000, result)

    }

    @Test
    fun checkNull2() {
        val inputValue = ""
        val result = checkNull(inputValue=inputValue)
        assertEquals(1, result)

    }

    @Test
    fun countCommission() {
        val currentMonthAmount = 100L
        val cardOrAccountType = "Maestro"
        val transferAmount = 1000L

        val result = countCommission(
            currentMonthAmount = currentMonthAmount,
            cardOrAccountType = cardOrAccountType,
            transferAmount = transferAmount
        )

        assertEquals(0, result)
    }

    @Test
    fun checkLimitsThenOutput() {
        val currentMonthAmount = 600_000_10L
        val cardOrAccountType = "Maestro"
        val transferAmount = 150_000_01L

        val result = checkLimitsThenOutput(
            currentMonthAmount = currentMonthAmount,
            cardOrAccountType = cardOrAccountType,
            transferAmount = transferAmount
        )

        assertEquals("Извините, но вы не укладываетесь в лимиты :(", result)
    }
}