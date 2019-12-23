@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import java.lang.IllegalArgumentException
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

//др в году
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

// цвет волосо 16число
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
                    print(answer)
                }
            }
        }

    }
    return 31
}

// компеклекные числа
class ComplexNumber(stringSequence: String) {
    private var a = (Regex("""\d+[^i\d]|\d+$""").find(stringSequence)?.value ?: "0").trim()
    private var b = (Regex("""(([+\-]) )?\d*+i""").find(stringSequence)?.value ?: "0").filter { it !in "i " }
    fun complexToInt(): Pair<Int, Int> {
        return when (b) {
            "+", "" -> a.toInt() to 1
            "-" -> a.toInt() to -1
            else -> a.toInt() to b.toInt()
        }
    }
}

fun ComplexMultyply(sequence: String): Pair<Int, Int> {
    val multipliers = sequence.split(";")
    var answer = ComplexNumber(multipliers[0]).complexToInt()
    for (i in 1..multipliers.lastIndex) {
        val a = answer.first
        val b = answer.second
        val c = ComplexNumber(multipliers[i]).complexToInt().first
        val d = ComplexNumber(multipliers[i]).complexToInt().second
        answer = a * c - b * d to a * d + b * c
    }
    return answer
}

//spam
fun Spam(str: String): Set<String> {
    val legal = "$str\n".contains(Regex("""^(\w+ \d\d?:\d\d\n)+$"""))
    if (!legal) {
        return setOf()
    }
    val chatters = str.split("\n")
    val listChat = chatters.map { it.split(" ")[0] to it.split(" ")[1] }
    val mapchat = mutableMapOf<String, List<Int>>()
    for ((name, second) in listChat) {
        val time = second.split(":")
        val hours = time[0].toInt()
        val minutes = time[1].toInt()
        if (hours > 23)
            return setOf()
        if (minutes > 60)
            return setOf()
        mapchat[name] = mapchat.getOrDefault(name, listOf()) + hours * 60 + minutes
    }
    val sortmap = mapchat.map { it.key to it.value.sorted() }
    val answer = mutableSetOf<String>()
    for ((name, timelist) in sortmap) {
        for (i in 0 until timelist.size - 1) {
            if (timelist[i + 1] - timelist[i] < 2) {
                answer += name
                break
            }
        }
    }
    return answer
}

//цыета волос человек цвет цвет цвет
fun myFun(people: List<String>): MutableSet<String> {
    val splittedPeople = people.map { val b = it.split(':'); b[0].trim(' ') to b[1].trim(' ').split(", ").toSet() }
    val answer = mutableSetOf<String>()
    for ((personName, personColors) in splittedPeople) {
        var allChecked = true
        for ((name, colors) in splittedPeople) {
            if (personColors == colors && personName != name) {
                allChecked = false
                break
            }
        }
        if (allChecked) answer.add("${personColors.joinToString()} -> $personName")
    }
    return answer
}

// биграммы
fun bigrams(text: String): Map<String, Int> {
    val answer = mutableMapOf<String, Int>()
    var filtered = Regex("""[.,-;?!()"]""").replace(text, " ")
    filtered = Regex("""\s+""").replace(filtered, " ")
    val wordlist = filtered.split(" ")
    for (word in wordlist) {
        val bigram = word.windowed(2, 1, false)
        for (bi in bigram) {
            answer[bi] = (answer[bi] ?: 0) + 1
        }
    }
    return answer
}

// телефоны иванов иван
fun telephones(name: String, text: String): MutableSet<String> {
    val answer = mutableSetOf<String>()
    for (entry in text.split(";\\s+".toRegex())) {
        val namePhone = entry.split(" +")
        if (namePhone.size != 2 || namePhone[1].contains("[^-0-9]".toRegex()))
            throw IllegalArgumentException()
        if (namePhone[0].trim(' ') == name)
            answer.add(" " + namePhone[1])
    }
    return answer
}

// поезда из а в б кирилл
fun train(from: String, to: String, route: String): String {
    val lCell = route.split(";")
    var timeS = ""
    var timeF = ""
    for (cell in lCell) {
        if (Regex(""" +.* +(\d\d):(\d\d)""").matches(cell)) {
            val data = cell.split(Regex(""" +"""))
            if (data[1] == from)
                timeS = data[2]
            if (data[1] == to)
                timeF = data[2]
        } else throw IllegalArgumentException()
    }
    require(!(timeS == "" || timeF == ""))
    val hours = timeF.split(";")[0].toInt() - timeS.split(";")[0].toInt()
    val minutes = timeF.split(";")[1].toInt() - timeS.split(";")[1].toInt()
    val time = hours * 60 + minutes
    return String.format("%02d:%02d", time / 60, time % 60)
}

//монетки разменять
fun money(sum: Double, coins: String): Collection<Any> {
    require(Regex("""([\d]+(\.\d\d*)*)(, [\d]+(\.\d\d*)*)*""").matches(coins))
    val sortedCoinList = coins.split(", ").sorted().reversed()
    var aux = sum
    var i = 0
    val answer = mutableListOf<String>()
    for (number in sortedCoinList) {
        while (aux / number.toDouble() > 1) {
            i++
            aux -= number.toDouble()
        }
        answer += "$i*$number"
        i = 0
    }
    return answer
}

//телефон старый
fun phoneNumber(text: String): String {
    val replacement = mapOf(
        listOf('a', 'b', 'c') to '2',
        listOf('d', 'e', 'f') to '3',
        listOf('g', 'h', 'i') to '4',
        listOf('j', 'k', 'l') to '5',
        listOf('m', 'n', 'o') to '6',
        listOf('p', 'q', 'r', 's') to '7',
        listOf('t', 'u', 'v') to '8',
        listOf('w', 'x', 'y', 'z') to '9'
    )
    require(Regex("""[\d\s-a-zA-Z]*[\da-zA-Z]+[\d\s-a-zA-Z]*""").matches(text))
    Regex("""\s+""").replace(text,"")
    var answer = text
    for (i in answer.indices) {
        for ((letters, digit) in replacement) {
            if (answer[i].toLowerCase() in letters) {
                answer = answer.replace(answer[i], digit)
                break
            }
        }
    }
    return answer
}