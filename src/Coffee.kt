import kotlinx.coroutines.delay

sealed class Coffee(var name: String, val sugar: Int, val milk: Int, val volume: Int) {

    class Espresso(name: String, sugar: Int, milk: Int, volume: Int): Coffee(name, sugar, milk, volume)
    class Americano(name: String, sugar: Int, milk: Int, volume: Int): Coffee(name, sugar, milk, volume)
    class Cappuccino(name: String, sugar: Int, milk: Int, volume: Int): Coffee(name, sugar, milk, volume)
    class Latte(name: String, sugar: Int, milk: Int, volume: Int): Coffee(name, sugar, milk, volume)
}