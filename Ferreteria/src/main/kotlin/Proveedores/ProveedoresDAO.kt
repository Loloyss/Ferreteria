package Proveedores

import Premios.Premios

interface ProveedoresDAO {
    fun getPremios():ArrayList<Proveedores>
    fun getPpremioID(id:String): Proveedores?
    fun insertPremios(Proveedores: Proveedores):Boolean
    fun insertArrPremios(arrProv: ArrayList<Proveedores>):Boolean
}