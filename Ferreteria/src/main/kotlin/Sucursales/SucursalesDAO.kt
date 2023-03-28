package Sucursales

import Premios.Premios

interface SucursalesDAO {

    fun getSucursales():ArrayList<Sucursales>
    fun getSucursalesID(id:String): Sucursales?
    fun insertSucursales(Sucursales: Sucursales):Boolean
    fun insertArrSucursales(arrSuc: ArrayList<Sucursales>):Boolean
}