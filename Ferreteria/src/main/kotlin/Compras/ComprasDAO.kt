package Compras

interface ComprasDAO {
    fun getCompras():ArrayList<Compras>
    fun getComprasByID(id:String): Compras?
    fun insertCompras(Compras: Compras):Boolean
    fun insertArrCompras(arrCompras: ArrayList<Compras>):Boolean
    fun eliminarCompraByart(cod_art:String,ref_art:String):Boolean

}