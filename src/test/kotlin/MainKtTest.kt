import org.junit.Assert.assertEquals
import org.junit.Test


class MainKtTest {

    @Test
    fun checkLimitVisa() {
        val typeOperation = "Visa"
        val monthLimitCard = 600_000
        val monthLimitVK = 40_000
        val dayLimitCard = 150_000
        val operationLimitVK = 15_000
        val previousOperationMonthCard = 0
        val previousOperationsDayCard = 0
        val previousOperationMonthVk: Int = 0
        val amountTransaction = 10_000
        var possibleTrascation = when {
            previousOperationMonthCard + amountTransaction > monthLimitCard || amountTransaction + previousOperationsDayCard > dayLimitCard ||
                    amountTransaction + previousOperationMonthVk > monthLimitVK || amountTransaction > operationLimitVK -> false
            else -> true
        }
        assertEquals(true, possibleTrascation)
    }

    @Test
    fun checkTypeVisa() {
        val typeOperation = "Visa"
        val minComissionVisa = 35
        val percentComissionVisa = 0.0075
        val percentComissionMC = 0.006
        val addComissionMC = 20
        val maxLimitFreeComissionMCMonth = 75_000
        val minLimitFreeComissionMCMonth = 300
        val previousOperationsDayCard = 0
        val amountTransaction = 10_000
        val possibleTransaction = true
        var result = 0
        when (possibleTransaction) {
            false -> println("Операция не может быть выполнена, так как превышен лимит. За подробностями обратитесь, пожалуйста, в ваш банк")
            else -> when (typeOperation) {
                "Visa", "Мир" -> when {
                    (amountTransaction * percentComissionVisa).toInt() > minComissionVisa -> result = (amountTransaction * percentComissionVisa).toInt()
                    else -> result = minComissionVisa
                }
                "Master Card", "Maestro" -> when {
                    amountTransaction > minLimitFreeComissionMCMonth && amountTransaction + previousOperationsDayCard <= maxLimitFreeComissionMCMonth -> result = 0
                    else -> result = (((amountTransaction - maxLimitFreeComissionMCMonth) * percentComissionMC).toInt() + addComissionMC)
                }
                else -> result = 0
            }
        }
        assertEquals(75,result)
    }
}

