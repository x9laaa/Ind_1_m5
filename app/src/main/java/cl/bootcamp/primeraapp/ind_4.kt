package cl.bootcamp.primeraapp
class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String? = null,
    val referencia: Usuario? = null
) {
    fun mostrarDatos() {
        val datos = mutableListOf<String>()
        datos.add(nombre)
        datos.add(edad.toString())
        trabajo?.let { datos.add(it) }
        referencia?.let { datos.add("referenciado por: ${it.nombre}") }
        println(datos.joinToString(" - "))
    }
}

class ListaUsuarios {
    private val usuarios: MutableList<Usuario> = mutableListOf()

    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        println("${usuario.nombre} ha sido agregado a la lista.")
    }

    fun eliminarUsuario(nombre: String) {
        val usuario = usuarios.find { it.nombre == nombre }
        if (usuario != null) {
            usuarios.remove(usuario)
            println("${usuario.nombre} ha sido eliminado de la lista.")
        } else {
            println("Usuario con nombre $nombre no encontrado.")
        }
    }

    fun mostrarLista() {
        if (usuarios.isEmpty()) {
            println("La lista de usuarios está vacía.")
        } else {
            usuarios.forEach { it.mostrarDatos() }
            println("----- Fin de la lista de usuarios -----")
        }
    }
}

fun main() {
    val listaUsuarios = ListaUsuarios()

    val usuario1 = Usuario("Alex", 30, "Desarrollador")
    val usuario2 = Usuario("Karina", 25)
    val usuario3 = Usuario("Luis", 40, "Doctor")
    val usuario4 = Usuario("Ana", 18, "Estudiante")
    val usuario5 = Usuario("María", 65,"Profesora", referencia = usuario1)

    listaUsuarios.agregarUsuario(usuario1)
    listaUsuarios.agregarUsuario(usuario2)
    listaUsuarios.agregarUsuario(usuario3)
    listaUsuarios.agregarUsuario(usuario4)
    listaUsuarios.agregarUsuario(usuario5)

    println("\nLista de usuarios:")
    listaUsuarios.mostrarLista()

    println("\nEliminando a Luis de la lista:")
    listaUsuarios.eliminarUsuario("Luis")

    println("\nLista de usuarios después de eliminar:")
    listaUsuarios.mostrarLista()
}
