package ru.netology

fun main() {

 var comissionLimit = checkLimit()
 var comissionType = checkType(comissionLimit)
}

fun  checkLimit (
    monthLimitCard: Int = 600_000,
    dayLimitCard: Int = 150_000,
    operationLimitVK: Int = 15_000,
    previousOperationMonthCard: Int = 0,
    previousOperationsDayCard: Int = 0,
    monthLimitVK: Int = 40_000,
    previousOperationMonthVk: Int = 0,
    amountTransaction: Int = 10_000) : Boolean {
    var possibleTranscation = when {
        previousOperationMonthCard + amountTransaction > monthLimitCard -> false
        amountTransaction + previousOperationsDayCard > dayLimitCard -> false
        amountTransaction + previousOperationMonthVk > monthLimitVK -> false
        amountTransaction > operationLimitVK-> false
        else -> true
    }
    return possibleTranscation
}

fun checkType (
    possibleTranscation : Boolean,
    typeOperation: String = "Visa",
    minComissionVisa: Int = 35,
    percentComissionVisa: Double = 0.0075,
    percentComissionMC: Double = 0.006,
    addComissionMC: Int = 20,
    maxLimitFreeComissionMCMonth: Int = 75_000,
    minLimitFreeComissionMCMonth: Int = 300,
    previousOperationsDayCard: Int = 0,
    amountTransaction: Int = 10_000 ) : Int  {
    var result = 0
    when (possibleTranscation) {
        false -> println("Операция не может быть выполнена, так как превышен лимит. За подробностями обратитесь, пожалуйста, в ваш банк")
        else -> when (typeOperation) {
            "Visa", "Мир" -> when {
                (amountTransaction * percentComissionVisa).toInt() > minComissionVisa -> result = (amountTransaction * percentComissionVisa).toInt()
                //println("Cумма комиссии за эту операцию по данной карте составит: " + (amountTransaction * percentComissionVisa).toInt() + " руб.")
                else -> result = minComissionVisa
            //println("Cумма комиссии за эту операцию по данной карте составит: " + minComissionVisa + " руб.")
            }
            "Master Card", "Maestro" -> when {
                amountTransaction > minLimitFreeComissionMCMonth && amountTransaction + previousOperationsDayCard <= maxLimitFreeComissionMCMonth -> result = 0
                //println("Cумма комиссии за эту операцию по данной карте составит: 0 руб.")
                amountTransaction < minLimitFreeComissionMCMonth -> result = (amountTransaction * percentComissionMC).toInt() + addComissionMC
                else -> result = ((amountTransaction - maxLimitFreeComissionMCMonth) * percentComissionMC).toInt() + addComissionMC
                //println(("Cумма комиссии за эту операцию по данной карте составит: ((amountTransaction -  maxLimitFreeComissionMCMonth) * percentComissionMC).toInt() + addComissionMC) + " руб"))
            }
            else -> result = 0 //println("Cумма комиссии за эту операцию по данной карте составит: 0 руб.")
        }
    }
    return result
}
