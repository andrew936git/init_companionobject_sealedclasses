import kotlinx.coroutines.delay

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() {
    println("Добро пожаловать")

    selectMenu(selectedMenu())

}

fun selectedMenu(): Coffee {
    println(
        """Выберите кофе:
            |1 - Эспрессо
            |2 - Американо
            |3 - Капучино
            |4 - Латте
        """.trimMargin()
    )

    when (readln().toInt()) {
        1 -> {
            val coffee = Coffee.Espresso("Эспрпессо", choiceSugar(), 0, 30)
            return coffee
        }

        2 -> {
            val coffee = Coffee.Americano("Американо", choiceSugar(), 0, choiceVolume("Американо"))
            return coffee
        }

        3 -> {
            val coffee = Coffee.Cappuccino("Капучино", choiceSugar(), choiceMilk("Капучино"), choiceVolume("Капучино"))
            return coffee
        }

        else -> {
            val coffee = Coffee.Latte("Латте", choiceSugar(), choiceMilk("Латте"), choiceVolume("Латте"))
            return coffee
        }
    }
}

fun choiceSugar(): Int {
    println(
        """Количество сахара: 
                    |1 - 0г.
                    |2 - 5г.
                    |3 - 10г.
                    |4 - 15г.
                """.trimMargin()
    )
    val num = when (readln().toInt()) {
        1 -> 0
        2 -> 5
        3 -> 10
        4 -> 15
        else -> 0
    }
    return num
}

fun choiceMilk(name: String): Int {
    var num = 0
    if (name == "Капучино") {
        println(
            """Количество молока: 
                    |1 - 120 мл.
                    |2 - 150 мл.
                    |3 - 180 мл.
                """.trimMargin()
        )
        when (readln().toInt()) {
            1 -> num = 120
            2 -> num = 150
            3 -> num = 180
        }
    } else {
        println(
            """Количество молока: 
                    |1 - 180 мл.
                    |2 - 200 мл.
                    |3 - 220 мл.
                """.trimMargin()
        )
        when (readln().toInt()) {
            1 -> num = 180
            2 -> num = 200
            3 -> num = 220
        }
    }
    return num
}

fun choiceVolume(name: String): Int {
    var num = 0
    when (name) {
        "Американо" -> {
            println(
                """Желаемый объем кофе: 
                    |1 - 90 мл.
                    |2 - 110 мл.
                    |3 - 150 мл.
                """.trimMargin()
            )
            when (readln().toInt()) {
                1 -> num = 90
                2 -> num = 110
                3 -> num = 150
            }
        }

        "Капучино" -> {
            println(
                """Желаемый объем кофе: 
                    |1 - 150 мл.
                    |2 - 200 мл.
                    |3 - 250 мл.
                """.trimMargin()
            )
            when (readln().toInt()) {
                1 -> num = 150
                2 -> num = 200
                3 -> num = 250
            }
        }

        else -> {
            println(
                """Желаемый объем кофе: 
                    |1 - 210 мл.
                    |2 - 230 мл.
                    |3 - 250 мл.
                """.trimMargin()
            )
            when (readln().toInt()) {
                1 -> num = 210
                2 -> num = 230
                3 -> num = 250
            }
        }
    }
    return num
}

suspend fun selectMenu(coffee: Coffee) {
    println("Идет приготовление кофе")
    for (i in 1..10) {
        delay(500L)
        println("${i * 10}%")
    }
    if (coffee is Coffee.Cappuccino || coffee is Coffee.Latte) {
        println(
            "Ваш кофе готов: ${coffee.name}, " +
                    "сахар: ${coffee.sugar}г., " +
                    "молоко: ${coffee.milk}мл., " +
                    "объем: ${coffee.volume}мл."
        )
    } else {
        println(
            "Ваш кофе готов: ${coffee.name}, " +
                    "сахар: ${coffee.sugar}г., " +
                    "объем: ${coffee.volume}мл."
        )
    }

}
