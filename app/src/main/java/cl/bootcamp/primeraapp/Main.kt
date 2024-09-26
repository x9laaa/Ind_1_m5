package cl.bootcamp.primeraapp

fun main(){

    println(calcularPrecioEntrada(3, "miércoles"))
    println(calcularPrecioEntrada(3, "miércoles"))
    println(calcularPrecioEntrada(10, "sábado"))
    println(calcularPrecioEntrada(25, "lunes"))
    println(calcularPrecioEntrada(35, "miércoles"))
    println(calcularPrecioEntrada(70, "domingo"))
    println(calcularPrecioEntrada(105, "jueves"))
}

fun calcularPrecioEntrada(edad: Int, diaSemana: String): String {
    if (edad < 0 || edad > 100) {
        return "Error: Edad fuera de rango"
    }

    return when {
        edad < 4 -> "Entrada gratuita para menores de 4 años"

        edad in 4..15 -> "El precio de la entrada es 15.000 CLP"

        edad in 16..60 -> {
            val precioAdulto = if (diaSemana.lowercase() == "lunes" || diaSemana.lowercase() == "martes") {
                30_000 - 5_000
            } else {
                30_000
            }
            "El precio de la entrada es $precioAdulto CLP"
        }

        edad > 60 -> "El precio de la entrada es 20.000 CLP"

        else -> "Error: Edad no válida"
    }
}