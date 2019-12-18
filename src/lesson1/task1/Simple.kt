@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import kotlin.math.*

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main() {
    val x1x2 = quadraticRootProduct(1.0, 13.0, 42.0)
    println("Root product: $x1x2")
}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int = hours * 3600 + minutes * 60 + seconds

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double =
    (sagenes * 48 + arshins * 16 + vershoks) * 4.445 / 100

/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double = (deg + min / 60.0 + sec / 3600.0) / 180 * PI

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double =
    sqrt(sqr((x2 - x1)) + sqr((y2 - y1)))

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int = (number / 100) % 10

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int =
    hoursArrive * 60 + minutesArrive - hoursDepart * 60 - minutesDepart

/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double =
    ((1 + percent / 100.0).pow(3)) * initial

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    val first = number % 10
    val second = number / 10 % 10
    val third = number / 100 % 10
    return first * 100 + second * 10 + third
}

fun DrVgodu(information: String): Int {
    val good = mapOf(
        "январь" to 9,
        "февраля" to 29,
        "март" to 9,
        "апрель" to 4,
        "май" to 4,
        "июнь" to 4,
        "июль" to 4,
        "август" to 4,
        "сентябрь" to 4,
        "октябрь" to 4,
        "ноябрь" to 4,
        "декабрь" to 4
    )
    val answer = mutableListOf<String>()
    val text = Regex("""\s+""").replace(information, " ")
    require(Regex("""[а-яА-ЯёЁ]+ \d\d [а-яА-ЯёЁ]+""").matches(text))
    val parts = text.split(", ")
    for (i in parts) {
        val salary = i.split(" ")
        if (salary[1].toInt() < good[salary[2]]!!)
            answer.add(i)
    }
    return 31
}

fun CvetKod(people: List<String>): Int {
    val mapOfColours = mutableMapOf<String, Int>()
    val answer = mutableListOf<String>()
    for (i in people) {
        require(Regex("""[а-яА-ЯёЁ]+ ([a-fA-F]|[0-9]){6}""").matches(i))
        val splitted = i.split(Regex("""\s+"""))
        if (splitted[1] in mapOfColours) mapOfColours[splitted[1]] = mapOfColours[splitted[1]]!! + 1
        else mapOfColours[splitted[1]] = 1
    }
    for ((key, value) in mapOfColours) {
        if (value == 1) {
            for (i in people) {
                val splitted = i.split(Regex("""\s+"""))
                if (splitted[1] == key) {
                    val x = splitted[0]
                    val y = splitted[1]
                    answer.add("$x -> $y")
                    print (answer)
                }
            }
        }

    }
    return 31
}