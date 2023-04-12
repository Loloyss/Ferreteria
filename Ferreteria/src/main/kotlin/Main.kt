import Articulos.Articulos
import Articulos.ArticulosDAOImpl
import Compras.ComprasDAOImpl
import Suministros.SuministrosDAOImpl

fun main() {

    println("Con que tabla quiere trabajar?")
    println("1. Artículos")
    println("2. Clientes")
    println("3. Compras")
    println("4. Medidas")
    println("____________________________________")
    println()
    var num = readln().toInt()
    when (num){
        1 -> {
            var tabla = "articulos"
            var choice = elecion(tabla)
            var test = ArticulosDAOImpl()
            var test2= ComprasDAOImpl()
            when (choice){
                1->{
                    var select = test.getArticulos()
                    for (i in select)
                        println(i)

                }
                2->{
                    var select = test.getArticulos()
                    for (i in select){
                        println(i)}

                    var search = buscar("")
                    var ref_art = buscar("ref_art")
                    println(test.getArticuloByID(search.toString(),ref_art.toString()))
                }
                3->{
                   println("Para realizar el insert se necesita un código de articulo: ")
                    var cod_art = readln()
                    println("se necesita la referencia del articulo: ")
                    var ref_art = readln()
                    println("La denominación: ")
                    var denomina = readln()
                    println("El precio: ")
                    var precio = readln().toFloat()
                    println("El descuento: ")
                    var descuento = readln().toFloat()
                    var articulo = Articulos(cod_art, ref_art, denomina, precio, descuento)
                    test.insertArticulo(articulo)
                }
                4->{
                    println("Para modificar un registro necesitas introducir el código del artículo: ")
                    var cod_art = readln()
                    println("Para modificar un registro necesitas introducir la referencia del artículo: ")
                    var ref_art = readln()
                    var articulo:Articulos=test.getArticuloByID(cod_art,ref_art)
                    println(articulo.toString())
                    println("Insertar la nueva denominacion del articulo: (antigua denominacio):${articulo.denomina}")
                    var denominacion = readln()
                    println("Insertar la nuevo precio del articulo: (antiguo precio):${articulo.precio}")
                    var precio = readln().toInt()
                    println("Insertar la nuevo descuento del articulo: (antiguo descuento):${articulo.descuento}")
                    var descuento = readln().toInt()
                    articulo.denomina=denominacion
                    articulo.precio= precio.toFloat()
                    articulo.descuento= descuento.toFloat()
                    test.modificarArticulo(articulo)
                    var art = test.getArticulos()
                    for (i in art){
                        println(i.toString())
                    }
                }
                5 -> {
                    println("Para borrar un registro necesitas introducir el código del artículo: ")
                    var cod_art = readln()
                    println("Para borrar un registro necesitas introducir la referencia del artículo: ")
                    var ref_art = readln()
                    test2.eliminarCompraByart(cod_art,ref_art)
                    test.eliminarArticulo(cod_art,ref_art)
                    var art = test.getArticulos()
                    for (i in art){
                        println(i.toString())
                    }
                }
                else -> {
                    println("elección incorrecta")
                }
            }

        }
    }
}

fun elecion(tabla:String):Int{


    println("¿Qué deseas hacer con esta tabla?")
    println("1. mostrar la tabla completa")
    println("2. mostrar un registro en concreto")
    println("3. Insertar un registro")
    println("4. Modificar un registro")
    println("5. Borrar un registro en concreto")

    println("Eligo la opción: ")

    var choice = readln().toInt()
    return choice
}

fun buscar(arg:String):String{

    if (arg.isEmpty())
    println("Indica el ID:")
    else
        println("Indica el $arg:")
    var x = readln()
    return x
}

/*fun borrar(borrado:Boolean){
    if (borrado){
        println("Borrado correcto")
    }
    else println("Borrado erroneo")
}*/