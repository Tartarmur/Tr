import org.junit.Test

import org.junit.Assert.*
import ru.netology.checkLimit
import ru.netology.checkType

class CheckTest {

    @Test
    fun visa() {
        val monthLimitCard = 600_000
        val monthLimitVK = 40_000
        val dayLimitCard = 150_000
        val operationLimitVK = 15_000
        val previousOperationMonthCard = 0
        val previousOperationsDayCard = 0
        val previousOperationsDayCard1 = 150_000
        val previousOperationMonthVk = 0
        val previousOperationMonthVk1 = 40_000
        val amountTransaction1 = 10_000
        val amountTransaction2 = 1_000_000
        val amountTransaction3 = 50
        val amountTransaction4 = 16_000
        val typeOperation = "Visa"
        val minComissionVisa = 35
        val percentComissionVisa = 0.0075
        val percentComissionMC = 0.006
        val addComissionMC = 20
        val maxLimitFreeComissionMCMonth = 75_000
        val minLimitFreeComissionMCMonth = 300

        val resultLimitVisa1  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction1)
        val resultLimitVisa2  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction2)
        val resultLimitVisa3 = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard1, monthLimitVK, previousOperationMonthVk, amountTransaction1)
        val resultLimitVisa4 = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk1, amountTransaction1)
        val resultLimitVisa5 = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction4)
        val totalResultLimitFalse1 = checkType(possibleTranscation = false, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction1)
        val totalResultLimitTrue1 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction1)
        val totalResultLimitTrue2 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction3)

        assertEquals(true, resultLimitVisa1)
        assertEquals(false, resultLimitVisa2)
        assertEquals(false,resultLimitVisa3)
        assertEquals(false,resultLimitVisa4)
        assertEquals(false,resultLimitVisa5)
        assertEquals(0, totalResultLimitFalse1)
        assertEquals(75, totalResultLimitTrue1)
        assertEquals(35, totalResultLimitTrue2)
    }


    @Test
    fun mir() {
        val monthLimitCard = 600_000
        val monthLimitVK = 40_000
        val dayLimitCard = 150_000
        val operationLimitVK = 15_000
        val previousOperationMonthCard = 0
        val previousOperationsDayCard = 0
        val previousOperationMonthVk: Int = 0
        val amountTransaction1 = 10_000
        val amountTransaction2 = 1_000_000
        val amountTransaction3 = 50
        val typeOperation = "Мир"
        val minComissionVisa = 35
        val percentComissionVisa = 0.0075
        val percentComissionMC = 0.006
        val addComissionMC = 20
        val maxLimitFreeComissionMCMonth = 75_000
        val minLimitFreeComissionMCMonth = 300

        val resultLimitVisa1  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction1)
        val resultLimitVisa2  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction2)
        val totalResultLimitFalse = checkType(possibleTranscation = false, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction1)
        val totalResultLimitTrue1 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction1)
        val totalResultLimitTrue2 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction3)

        assertEquals(true, resultLimitVisa1)
        assertEquals(false, resultLimitVisa2)
        assertEquals(0, totalResultLimitFalse)
        assertEquals(75, totalResultLimitTrue1)
        assertEquals(35, totalResultLimitTrue2)
    }

    @Test
    fun masterCard() {
        val monthLimitCard = 600_000
        val monthLimitVK = 40_000
        val dayLimitCard = 150_000
        val operationLimitVK = 15_000
        val previousOperationMonthCard = 0
        val previousOperationsDayCard = 0
        val previousOperationMonthVk: Int = 0
        val amountTransaction1 = 10_000
        val amountTransaction2 = 1_000_000
        val typeOperation = "Master Card"
        val minComissionVisa = 35
        val percentComissionVisa = 0.0075
        val percentComissionMC = 0.006
        val addComissionMC = 20
        val maxLimitFreeComissionMCMonth = 75_000
        val minLimitFreeComissionMCMonth = 300

        val resultLimitMC1  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction1)
        val resultLimitMC2  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction2)
        val totalResultLimitFalse = checkType(possibleTranscation = false, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction1)
        val totalResult1 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction1)
        val totalResult2 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction2)

        assertEquals(true, resultLimitMC1)
        assertEquals(false, resultLimitMC2)
        assertEquals(0,totalResultLimitFalse)
        assertEquals(0, totalResult1)
        assertEquals(5_570,totalResult2)
    }

    @Test
    fun maestro() {
        val monthLimitCard = 600_000
        val monthLimitVK = 40_000
        val dayLimitCard = 150_000
        val operationLimitVK = 15_000
        val previousOperationMonthCard = 0
        val previousOperationsDayCard = 0
        val previousOperationMonthVk: Int = 0
        val amountTransaction1 = 10_000
        val amountTransaction2 = 1_000_000
        val amountTransaction3 = 50
        val typeOperation = "Maestro"
        val minComissionVisa = 35
        val percentComissionVisa = 0.0075
        val percentComissionMC = 0.006
        val addComissionMC = 20
        val maxLimitFreeComissionMCMonth = 75_000
        val minLimitFreeComissionMCMonth = 300

        val resultLimitMC1  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction1)
        val resultLimitMC2  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction2)
        val totalResult1 = checkType(possibleTranscation = false, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction2)
        val totalResult2 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction2)
        val totalResult3 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction3)

        assertEquals(true, resultLimitMC1)
        assertEquals(false, resultLimitMC2)
        assertEquals(0, totalResult1)
        assertEquals(5_570,totalResult2)
        assertEquals(20,totalResult3)
    }

    @Test
    fun vk() {
        val monthLimitCard = 600_000
        val monthLimitVK = 40_000
        val dayLimitCard = 150_000
        val operationLimitVK = 15_000
        val previousOperationMonthCard = 0
        val previousOperationsDayCard = 0
        val previousOperationMonthVk: Int = 0
        val amountTransaction1 = 10_000
        val amountTransaction2 = 1_000_000
        val typeOperation = "VK"
        val minComissionVisa = 35
        val percentComissionVisa = 0.0075
        val percentComissionMC = 0.006
        val addComissionMC = 20
        val maxLimitFreeComissionMCMonth = 75_000
        val minLimitFreeComissionMCMonth = 300

        val resultLimitMC1  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction1)
        val resultLimitMC2  = checkLimit(monthLimitCard, dayLimitCard, operationLimitVK, previousOperationMonthCard, previousOperationsDayCard, monthLimitVK, previousOperationMonthVk, amountTransaction2)
        val totalResult1 = checkType(possibleTranscation = false, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction1)
        val totalResult2 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction2)
        val totalResult3 = checkType(possibleTranscation = true, typeOperation, minComissionVisa, percentComissionVisa, percentComissionMC, addComissionMC, maxLimitFreeComissionMCMonth, minLimitFreeComissionMCMonth, previousOperationsDayCard, amountTransaction1)

        assertEquals(true, resultLimitMC1)
        assertEquals(false, resultLimitMC2)
        assertEquals(0, totalResult1)
        assertEquals(0,totalResult2)
        assertEquals(0,totalResult3)
    }
}