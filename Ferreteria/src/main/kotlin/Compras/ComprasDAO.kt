package Compras

import Articulos.Articulos
import Clientes.Clientes

interface ComprasDAO {
    fun getCompras():ArrayList<Compras>
    fun getComprasByID(id:String): Compras?
    fun insertCompras(Compras: Compras):Boolean
    fun insertArrCompras(arrCompras: ArrayList<Compras>):Boolean
}