package Articulos

interface ArticulosDAO {
    fun getArticulos():ArrayList<Articulos>
    fun getArticuloByID(id:Int): Articulos
    fun insertArticulo(articulo:Articulos):Boolean
    fun insertArrArticulo(arrArticulo: ArrayList<Articulos>):Boolean
}