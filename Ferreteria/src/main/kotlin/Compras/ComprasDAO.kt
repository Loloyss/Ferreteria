package Compras

interface ComprasDAO {
    fun getCompras():ArrayList<Medidas>
    fun getComprasByID(id:String): Medidas?
    fun insertCompras(Compras: Medidas):Boolean
    fun insertArrCompras(arrCompras: ArrayList<Medidas>):Boolean
}