package cl.bootcamp.primeraapp


class ListaUsuarios5 {
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
            usuarios.forEach { it.mostrarDatosV2() }
            println("----- Fin de la lista de usuarios -----")
        }
    }

    fun filtrarUsuariosPorEdad(edad: Int): List<Usuario> {
        return usuarios.filter { it.edad > edad }
    }

    fun mostrarUsuariosFiltrados(edad: Int) {
        val usuariosFiltrados = filtrarUsuariosPorEdad(edad)
        if (usuariosFiltrados.isEmpty()) {
            println("No se encontraron usuarios mayores a $edad años.")
        } else {
            println("Usuarios mayores a $edad años:")
            usuariosFiltrados.forEach { println("${it.nombre} - ${it.edad}") }
        }
    }

}

fun main() {
    val listaUsuarios = ListaUsuarios5()

    val usuario1 = Usuario("Alex", 30, "Desarrollador")
    val usuario2 = Usuario("Karina", 25)
    val usuario3 = Usuario("Luis", 40, "Doctor")
    val usuario4 = Usuario("Ana", 18, "Estudiante")
    val usuario5 = Usuario("María", 65, referencia = usuario1)

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

    println("\nFiltrando usuarios mayores a 24 años")
    listaUsuarios.mostrarUsuariosFiltrados(24)
}
