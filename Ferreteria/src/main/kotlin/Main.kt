import Articulos.Articulos
import Articulos.ArticulosDAOImpl
import Clientes.Clientes
import Clientes.ClientesDAOImpl
import Compras.ComprasDAOImpl
import Compras.Medidas
import Medidas.Medidas
import Medidas.MedidasDAOImpl
import Poblaciones.PoblacionesDAOImpl
import Premios.Premios
import Premios.PremiosDAOImpl
import Proveedores.Proveedores
import Proveedores.ProveedoresDAOImpl
import Sucursales.SucursalesDAOImpl
import Suministros.Suministros
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
            when (choice){
                1->{
                   /* var emple = test.getArticulos()
                    for (i in emple){
                        println(i)
                    }*/
                }
                2->{
                    /*var search = buscar()
                    println(test.getArticulos(search))*/
                }
                3->{
                   /* println("Para realizar el insert se necesita un DNI: ")
                    var dni = readln().toInt()
                    println("El puesto: ")
                    var puesto = readln().toInt()
                    println("El nombreo: ")
                    var nombre = readln()
                    test.insertArticulo(dni,puesto,nombre)*/
                }
                4->{
                    println("Para modificar un registro necesitas introducir el código del artículo: ")
                    var cod_art = readln()
                    println("Para modificar un registro necesitas introducir la referencia del artículo: ")
                    var ref_art = readln()

                    println(test.getArticulos(cod_art,ref_art))
                }
                5 -> {
                    /*var search = buscar()
                    var borrado = test.deleteEmpleado(search)
                    borrar(borrado)*/

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

/*fun buscar():Int{

    println("Indica el ID:")

    var x = readln().toInt()
    return x
}*/

/*fun borrar(borrado:Boolean){
    if (borrado){
        println("Borrado correcto")
    }
    else println("Borrado erroneo")
}*/