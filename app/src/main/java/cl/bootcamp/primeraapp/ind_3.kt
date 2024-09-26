package cl.bootcamp.primeraapp

class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String? = null,
    val referencia: Usuario? = null
) {

    fun mostrarDatos() {
        println("Nombre: $nombre")
        println("Edad: $edad")
        println("Trabajo: ${trabajo ?: "Sin trabajo"}")
        if (referencia != null) {
            println("Fue citado por: ${referencia.nombre}")
        } else {
            println("Fue citado por: Sin referencia")
        }
    }
}

fun main() {
    val usuario1 = Usuario(nombre = "Alex Carreño", edad = 30, trabajo = "Desarrollador")
    val usuario2 = Usuario(nombre = "Karina Pino", edad = 25, referencia = usuario1)

    usuario1.mostrarDatos()
    println("-----")
    usuario2.mostrarDatos()
}
