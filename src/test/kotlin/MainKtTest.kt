import org.junit.Assert.assertEquals
import org.junit.Test


class MainKtTest {



  //  @Test
   // fun main() {
  //  }

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
        assertEquals(true,possibleTrascation)
    }
    }

   // @Test
   // fun checkType() {
  //  }
//}

