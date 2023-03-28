import Articulos.ArticulosDAOImpl

fun main(args: Array<String>) {
    var test = ArticulosDAOImpl()

    var arti = test.getArticulos()

    for (i in arti){
        println(i)
    }
}