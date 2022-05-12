
fun main() {

    var currentMonthAmount: Long = 0
    val cardOrAccountType: String
    val transferAmount: Long

    println("Введите тип карты/счета (Visa / MasterCard / Maestro / Мир / Счет VK Pay)")
    cardOrAccountType = readLine().toString()
    println("На какую сумму вы уже совершали переводы в этом месяце?")
    currentMonthAmount = checkNull(readLine().toString())
    println("Ввведите сумму перевода в копейках")
    transferAmount = checkNull(readLine().toString())
    println(checkLimitsThenOutput(currentMonthAmount, cardOrAccountType, transferAmount))
}

fun checkNull(inputValue: String): Long {
    if (inputValue != "") {
        return inputValue.toLong()
    } else {
        return 0
    }
}

fun countCommission(currentMonthAmount: Long, cardOrAccountType: String, transferAmount: Long): Long {
    val comission: Long
    if (cardOrAccountType == "MasterCard" || cardOrAccountType == "Maestro") {
        return if (currentMonthAmount < 75_000_00) {
            0
        } else {
            comission = transferAmount / 1_000 * 6 + 20_00
            comission
        }
    } else if (cardOrAccountType == "Visa" || cardOrAccountType == "Мир") {
        return if (transferAmount < 4_666_67) {
            35_00
        } else {
            comission = (transferAmount / 10_000 + 1) * 75
            comission
        }
    } else {
        return 0
    }
}

fun checkLimitsThenOutput(currentMonthAmount: Long, cardOrAccountType: String, transferAmount: Long): String {
    return if (((cardOrAccountType == "Visa" || cardOrAccountType == "MasterCard" || cardOrAccountType == "Maestro"
                || cardOrAccountType == "Мир") && currentMonthAmount <= 600_000_00 && transferAmount <= 150_000_00)
        || (cardOrAccountType == "Счет VK Pay" && currentMonthAmount <= 40_000_00 && transferAmount <= 15_000_00)
    ) {
        "Комиссия составит ${countCommission(currentMonthAmount, cardOrAccountType, transferAmount)} копеек"
    } else {
        "Извините, но вы не укладываетесь в лимиты :("
    }
}