package ru.netology

fun main() {

 var comissionLimit = checkLimit()
 var comissionType = checkType(comissionLimit)
}

fun  checkLimit () : Boolean {
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
        amountTransaction + previousOperationMonthVk > monthLimitVK || amountTransaction > operationLimitVK-> false
        else -> true
    }
    return possibleTrascation
}

fun checkType (possibleTrascation : Boolean)  {
    val typeOperation = "Visa"
    val minComissionVisa = 35
    val percentComissionVisa = 0.0075
    val percentComissionMC = 0.006
    val addComissionMC = 20
    val maxLimitFreeComissionMCMonth = 75_000
    val minLimitFreeComissionMCMonth = 300
    val previousOperationsDayCard = 0
    val amountTransaction = 10_000
    when (possibleTrascation) {
        false -> println("Операция не может быть выполнена, так как превышен лимит. За подробностями обратитесь, пожалуйста, в ваш банк")
        else -> when (typeOperation) {
            "Visa","Мир" -> when {
                (amountTransaction * percentComissionVisa).toInt() > minComissionVisa -> println("Cумма комиссии за эту операцию по данной карте составит: " + (amountTransaction * percentComissionVisa).toInt() + " руб.")
                else -> println("Cумма комиссии за эту операцию по данной карте составит: " + minComissionVisa + " руб.")
            }
            "Master Card","Maestro" -> when {
                amountTransaction  > minLimitFreeComissionMCMonth && amountTransaction + previousOperationsDayCard <= maxLimitFreeComissionMCMonth -> println("Cумма комиссии за эту операцию по данной карте составит: 0 руб.")
                else -> println(("Cумма комиссии за эту операцию по данной карте составит: " + (((amountTransaction -  maxLimitFreeComissionMCMonth) * percentComissionMC).toInt() + addComissionMC) + " руб"))
            }
            else -> println("Cумма комиссии за эту операцию по данной карте составит: 0 руб.")
        }
    }
}