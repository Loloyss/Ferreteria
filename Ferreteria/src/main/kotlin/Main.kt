import Articulos.ArticulosDAOImpl
import Clientes.ClientesDAOImpl

/**
* @author Francisco, Javier, Badrelddin
* */

fun main(args: Array<String>) {
    var test = ClientesDAOImpl()

    var arti = test.getClienteByID("0001")

    println(arti)

}