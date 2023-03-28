package Clientes

import Articulos.Articulos

interface ClientesDAO {
    fun getClientes():ArrayList<Clientes>
    fun getClienteByID(id:String): Clientes?
    fun insertClientes(articulo: Articulos):Boolean
    fun insertArrClientes(arrArticulo: ArrayList<Articulos>):Boolean
}